/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.handlingbaddata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import reactor.core.publisher.Flux;

/**
 *
 * @author Oula
 */
public class DataHandler {

    private Flux<String> myLetters;
    private final List<Integer> myList;

    public DataHandler() {
        myList = new ArrayList<>();
    }

    public void run() {
        Random rand = new Random();
        int i = rand.nextInt(20) + 1;

        for (int j = 0; j < i; j++) {
            int n = rand.nextInt(30) + 1;
            myList.add(n);
        }

        myLetters = Flux.fromIterable(myList).handle(
                (state, sink) -> {
                    String letter = checkLetter(state);
                    if (letter != null) {
                        sink.next(letter);
                    } else {
                        sink.next("!");
                    }
                }
        );
        myLetters.subscribe(data -> System.out.print(data));
    }

    public String checkLetter(int number) {
        if (number > 26) {
            return null;
        }
        int asLetter = 'A' + (number - 1);
        return "" + (char) asLetter;
    }
}
