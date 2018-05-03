/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.web;

import com.opiframe.java.ReactiveCarShop.domain.Car;
import com.opiframe.java.ReactiveCarShop.domain.HillBilly;
import com.opiframe.java.ReactiveCarShop.service.CarService;
import com.opiframe.java.ReactiveCarShop.service.HillBillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Oula
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private HillBillyService hbService;

    @GetMapping(value = "/api/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<Car>> getCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping(value = "/api/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>("{\"message\": \"Success\"}", HttpStatus.OK);
    }

    @GetMapping(value = "/api/car/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Car> getCarStream() {
        return carService.streamCars();
    }

    @GetMapping(value = "/api/car/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<Car>> searchCar(@RequestParam("searchType") String search, @RequestParam("param1") String param1, @RequestParam(value = "param2", required = false) String param2) {
        if ("type".equals(search)) {
            return new ResponseEntity<Flux<Car>>(carService.findByType(param1), HttpStatus.OK);
        }
        if ("year".equals(search)) {
            try {
                int temp = Integer.parseInt(param1);
                return new ResponseEntity<Flux<Car>>(carService.findByYear(temp), HttpStatus.OK);
            } catch (NumberFormatException e) {
                System.out.println("Not found");
            }
        }
        if ("price".equals(search)) {
            if (!"".equals(param2) && null != param2) {
                try {
                    int temp = Integer.parseInt(param1);
                    int temp2 = Integer.parseInt(param2);
                    return new ResponseEntity<>(carService.findByPrice(temp, temp2), HttpStatus.OK);
                } catch (NumberFormatException e) {
                    System.out.println("Not found");
                }
            }
        }
        return new ResponseEntity<Flux<Car>>(Flux.just(new Car()), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/car/{id}")
    public ResponseEntity<String> removeCar(@PathVariable String id) {
        System.out.println(id);
        if (carService.removeCar(id)) {
            return new ResponseEntity<>("{\"message\":\"success\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"message\":\"not found\"}", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/car")
    public ResponseEntity<String> editCar(@RequestBody Car car) {
        System.out.println(car);
        if (carService.editCar(car)) {
            return new ResponseEntity<>("{\"message\":\"success\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"message\":\"not found\"}", HttpStatus.NOT_FOUND);

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody HillBilly hb) {
        if (!"".equals(hb.getUserName()) && !"".equals(hb.getPassphrase())) {
            boolean temp = hbService.register(hb);
            if (temp) {
                return new ResponseEntity<>("{\"message\":\"Success\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"message\":\"Conflict\"}", HttpStatus.CONFLICT);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody HillBilly hb) {
        if (!"".equals(hb.getUserName()) && !"".equals(hb.getPassphrase())) {
            String temp = hbService.login(hb.getUserName(), hb.getPassphrase());
            if (temp.length() > 0) {
                return new ResponseEntity<>("{\"token\":\"" + temp + "\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"token\":\"\"}", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String token) {
        if (!"".equals(token)) {
            if (hbService.logout(token)) {
                return new ResponseEntity<>("{\"message\":\"Success\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("{\"message\":\"Not found\"}", HttpStatus.NOT_FOUND);
    }
}
