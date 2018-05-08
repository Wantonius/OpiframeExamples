/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

/**
 *
 * @author Erno Hentonen
 */

//This is our base class. It is abstract since there are no concrete object that is just "animal". 
//Abstract classes can be thought of as a group of object types that do not have singular concrete instances.
//There are millions of Animals, but none are just an Animal. They are always a Dog or a Cat or a Monkey and so on.
//The variables that are common to all animals like age and weight are housed here.

public abstract class Animal {
    
    private double weight;
    private int age;

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    
}
