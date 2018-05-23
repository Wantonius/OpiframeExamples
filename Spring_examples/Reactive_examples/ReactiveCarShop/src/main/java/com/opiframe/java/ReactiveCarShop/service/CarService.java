/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.service;

import com.opiframe.java.ReactiveCarShop.domain.Car;
import com.opiframe.java.ReactiveCarShop.domain.ICarShop;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Service
public class CarService {

    @Autowired
    ICarShop carRepo;

    boolean isFound;

    public Mono<Car> findById(String id) {
        if (!"".equals(id) && id != null) {
            return carRepo.findById(id);
        }
        return null;
    }

    public Flux<Car> findByType(String type) {
        return carRepo.findByTypeIgnoreCase(type);
    }

    public Flux<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Flux<Car> findByPrice(int greaterThan, int lessThan) {
        return carRepo.findByPrice(greaterThan, lessThan);
    }

    public Flux<Car> findByYear(int year) {
        return carRepo.findByYear(year);
    }

    public boolean addCar(Car car) {
        try {
            Mono<Car> temp = Mono.just(car);
            carRepo.insert(temp).then().subscribe();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeCar(String id) {
        carRepo.findById(id).hasElement().subscribe(data -> {
            if (data) {
                carRepo.deleteById(id).then().subscribe();
                this.isFound = true;
            } else {
                this.isFound = false;
            }
        });
        return true;
    }

    public Flux<Car> streamCars() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
        interval.subscribe();

        Flux<Car> temp = this.getAllCars();
        return Flux.zip(interval, temp).map(tuple -> tuple.getT2());
    }

    public boolean editCar(Car car) {
        if (car != null && car.getId().length() > 0) {
            carRepo.updateCar(car);
            return true;
        }
        return false;
    }
}
