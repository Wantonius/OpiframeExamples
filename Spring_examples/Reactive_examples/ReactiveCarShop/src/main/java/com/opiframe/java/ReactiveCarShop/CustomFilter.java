/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Component
public class CustomFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange swe, WebFilterChain wfc) {
        if (swe.getRequest().getURI().getPath().equals("/")) {
            return wfc.filter(swe.mutate().request(swe.getRequest().mutate().path("/index.html").build()).build());
        }
        return wfc.filter(swe);
    }
    

}
