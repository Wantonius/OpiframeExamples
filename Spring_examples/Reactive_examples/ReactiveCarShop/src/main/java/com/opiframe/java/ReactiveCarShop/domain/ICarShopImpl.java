/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.domain;

import com.mongodb.client.result.UpdateResult;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ICarShopImpl implements ICustomCarShop {

    @Autowired
    ReactiveMongoTemplate template;

    @Override
    public void updateCar(Car car) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(car.getId()));
        Update update = new Update();
        update.set("type", car.getType());
        update.set("year", car.getYear());
        update.set("price", car.getPrice());
        Mono<UpdateResult> temp = template.updateFirst(query, update, "car");
        temp.subscribe(data->System.out.println(data.toString()));
    }

}
