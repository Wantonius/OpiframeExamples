/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.HelloReactiveWeb;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Service
public class HelloReactiveService {
    private Message message;
    
    public HelloReactiveService(){
        message = new Message();
        message.setPayload("Hello world");
        message.setSender("Jaska");
        message.setTarget("World");
        
    }
    
    public Mono<Message> getMessage(){
        return Mono.just(this.message);
    }
}
