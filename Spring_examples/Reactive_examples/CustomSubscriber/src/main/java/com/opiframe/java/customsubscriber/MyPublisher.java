/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.customsubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactor.core.publisher.Flux;

/**
 *
 * @author Oula
 */
public class MyPublisher {
    
    private static final Logger LOGGER = Logger.getLogger(MyPublisher.class.getName());
    
    private final Flux<Person> personFlux;
    private final List<Person> personList;
    private final MySubscriber<Person> sub;
    
    public MyPublisher() {
        personList = new ArrayList<>();
        Person temp1 = new Person("Matti", "Meikalainen");
        Person temp2 = new Person("Jaska", "Jokunen");
        Person temp3 = new Person("Teppo", "Teikalainen");
        personList.add(temp1);
        personList.add(temp2);
        personList.add(temp3);
        
        personFlux = Flux.fromIterable(personList);
        sub = new MySubscriber<>();
        
        LOGGER.log(Level.INFO, "Constructed");
    }
    
    public void run(){
        personFlux.subscribe(sub);
    }
}
