/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
public interface IUserRepo extends ReactiveMongoRepository<HillBilly, String> {
    Mono<HillBilly> findByUserName(String userName);
}
