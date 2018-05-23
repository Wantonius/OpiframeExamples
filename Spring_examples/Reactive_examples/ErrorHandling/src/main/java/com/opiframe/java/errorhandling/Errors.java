/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.errorhandling;

import reactor.core.publisher.Flux;

/**
 *
 * @author Oula
 */
public class Errors {
    private final Flux<Integer> intFlux;
    
    public Errors(){
        intFlux = Flux.range(0, 5).map(i->{
            if(i<4){
                return i;
            }
            throw new RuntimeException("Too large");
        });
    }
    
    public void run(){
        intFlux.subscribe(
                i->System.out.println("Number is " + i),
                error->System.out.println(error));
    }
}
