/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.generatingflux;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 *
 * @author Oula
 */
public class CarShop {

    private Flux<Car> carFlux;
    private List<Car> carList;

    public CarShop() {
        carList = new ArrayList<>();
        Car temp1 = new Car("Audi", 5000);
        Car temp2 = new Car("Lada", 200);
        Car temp3 = new Car("Volvo", 10000);
        Car temp4 = new Car("🍍", 3);

        carList.add(temp1);
        carList.add(temp2);
        carList.add(temp3);
        carList.add(temp4);
    }

    public void run() {
        carFlux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next(carList.get(state));
                    if (state == carList.size() - 1) {
                        sink.complete();
                    }
                    return ++state;

                });
        carFlux.map(data -> data.toString()).subscribe(
                data -> System.out.println("Car for sale: " + data),
                error -> System.out.println(error),
                () -> System.out.println("All cars listed"));
    }

}
