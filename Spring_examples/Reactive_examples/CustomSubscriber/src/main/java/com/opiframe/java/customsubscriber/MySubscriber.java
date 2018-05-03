/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.customsubscriber;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 *
 * @author Oula
 */
public class MySubscriber<T> extends BaseSubscriber<T>{
    private static final Logger LOGGER = Logger.getLogger(MySubscriber.class.getName());
    
    @Override
    public void hookOnSubscribe(Subscription sub){
        LOGGER.log(Level.INFO, "Subscribed to MySubscribe");
        request(1);
    }
    
    @Override
    public void hookOnNext(T value){
        LOGGER.log(Level.INFO, "Next value: {0}", value.toString());
        request(1);
    }
    
    @Override
    public void hookOnComplete(){
        LOGGER.log(Level.INFO, "Complete");
    }
    
    @Override
    public void hookOnCancel(){
        LOGGER.log(Level.INFO, "Cancelllllled");        
    }   
}
