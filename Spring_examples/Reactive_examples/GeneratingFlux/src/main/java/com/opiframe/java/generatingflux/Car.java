/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.generatingflux;

/**
 *
 * @author Oula
 */
public class Car {
    private String type;
    private int price;
    
    public Car(){
        
    }
    
    public Car(String type, int price){
        this.type = type;
        this.price = price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return this.type + ", " + this.price;
    }
    
}
