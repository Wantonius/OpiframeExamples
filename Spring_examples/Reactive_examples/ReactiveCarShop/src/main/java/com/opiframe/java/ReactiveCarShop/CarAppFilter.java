/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop;

import com.opiframe.java.ReactiveCarShop.service.HillBillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class CarAppFilter implements WebFilter {

    @Autowired
    HillBillyService hbService;

    @Override
    public Mono<Void> filter(ServerWebExchange swe, WebFilterChain wfc) {
        if (swe.getRequest().getURI().getPath().startsWith("/api/car")) {
            String token = swe.getAttribute("token");
            if (hbService.isUserLogged(token)) {
                return wfc.filter(swe);
            }
        }
        swe.transformUrl("/");
        return wfc.filter(swe);
    }

}
