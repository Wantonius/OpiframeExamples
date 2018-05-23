/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Erno Hentonen
 */
public class Storage {
    
    private List<Apple> apples = new ArrayList<>();
    private Map<String,Car> cars = new HashMap<>();
    
    
    public boolean addAnApple(Apple apple) {
        if (!apples.contains(apple)) {
            System.out.println("Storing an apple. Color "+apple.getColor());
            apples.add(apple);
            return true;
        }
        return false;
    }
    
    public void eatAnApple() {
        if (!apples.isEmpty()) {
            Apple apple = apples.get(apples.size()-1);

            if (apple.getColor() == Apple.COLOR_BROWN) {
                System.out.println("Augh, Rotten apple!");
            } else {
                System.out.println("Nom nom");
            }
            apples.remove(apples.size()-1);
    } else {
            System.out.println("No more apples");
        }
    
    }
    
    public List<Apple> getAppleList() {
        return apples;
    }
 
    public boolean storeACar(Car car) {
        if (!cars.containsKey(car.getLicensePlate())) {
           System.out.println("Storing a car. Type "+car.getType());
            cars.put(car.getLicensePlate(), car);
            return true;
        }
        return false;
    }
    
    public Car getACar(String licenseplate) {
        if (cars.containsKey(licenseplate)) {
            System.out.println("Getting a car. Licenseplate: "+licenseplate);
            return cars.get(licenseplate);
        }
        return null;
    }
    public boolean removeACar(String licenseplate) {
        if (cars.containsKey(licenseplate)) {
            System.out.println("Removing a car. Licenseplate: "+licenseplate);
            cars.remove(licenseplate);
            return true;
        }
        return false;
    }
    
    
    public boolean findACar(String licenseplate) {
        if (cars.containsKey(licenseplate)) {
            return true;
        }
        return false;
    }
    
    public Map<String,Car> getCarStorage() {
        return cars;
    }
}

   
