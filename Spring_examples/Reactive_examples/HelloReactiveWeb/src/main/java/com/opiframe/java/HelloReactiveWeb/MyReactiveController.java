/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.HelloReactiveWeb;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Controller
public class MyReactiveController {

    @Autowired
    HelloReactiveService service;

    boolean isNotEmpty;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Publisher<Message> getHelloWorld() {
        service.getMessage().hasElement().subscribe(data -> this.isNotEmpty = data);
        if (isNotEmpty) {
            service.getMessage().subscribe(data -> System.out.println(data.getPayload()));
        }
        return service.getMessage();
    }
}
