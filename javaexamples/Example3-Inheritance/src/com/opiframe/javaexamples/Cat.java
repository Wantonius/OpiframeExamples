/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

/**
 *
 * @author Erno Hentonen
 *
 */

//Cat also extends Mammal like Dog. It has an unique voice and toString method.
public class Cat extends Mammal {
    
    //We override makeNoise from Mammal. Then we proceed to call superclass method and then we will do what we need to.
    //This is a very common scenario.
    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println(this.getName()+" meows!!");
    }
 
    //toString is actually housed in Object. Since Animal class doesn't explicitly extend any other class it automatically extends Object. Thus
    //through the hierarchy we have access to toString.
    @Override
    public String toString() {
        return "This Cat is called "+this.getName()+" and it weighs "+this.getWeight()+" and is "+this.getAge()+" years old";
    }
    
}
