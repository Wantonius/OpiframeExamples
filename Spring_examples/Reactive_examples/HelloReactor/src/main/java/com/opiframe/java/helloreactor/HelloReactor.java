/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.helloreactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
public class HelloReactor {

    private final Flux<String> helloFlux;
    private final Mono<String> helloMono;

    public HelloReactor() {
        helloFlux = Flux.just("Hello World", "Hello Kaikki", "Hello Jaska");
        helloMono = Mono.just("Hello Mono");
    }

    public void run() throws InterruptedException {
        helloFlux.count().subscribe(data -> System.out.println(data));
        helloFlux.log().subscribe(data -> System.out.println(data));
        helloMono.subscribe(data -> System.out.println(data));
        Thread.sleep(1000);
        helloFlux.subscribe(
                data -> System.out.println(data),
                error -> System.out.println(error),
                () -> System.out.println("Complete"));
    }
}
