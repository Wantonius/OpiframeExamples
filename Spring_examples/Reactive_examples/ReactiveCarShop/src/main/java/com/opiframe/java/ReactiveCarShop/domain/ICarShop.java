/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 *
 * @author Oula
 */
@Repository
public interface ICarShop extends ReactiveMongoRepository<Car, String>, ICustomCarShop {

    Flux<Car> findByTypeIgnoreCase(String type);
    Flux<Car> findByYear(int year);
    @Query("{price:{$gte:?0,$lte:?1}}")
    Flux<Car> findByPrice(int greaterThan, int lessThan);
    
}
