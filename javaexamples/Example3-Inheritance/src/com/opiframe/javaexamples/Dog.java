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

// All the attributes for dog are inherited from Animal and Mammal. Dog makes an unique noise.
// toString-method is available to all classes. It is often used to represent the variables of the class in a text form.
// In other cases it can be used to make a String version of the Object. Like for an UI.
public class Dog extends Mammal {
 
    //We override makeNoise from Mammal. Then we proceed to call superclass method and then we will do what we need to.
    //This is a very common scenario.
    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println(this.getName()+" Barks!!");
    }
    //toString is actually housed in Object. Since Animal class doesn't explicitly extend any other class it automatically extends Object. Thus
    //through the hierarchy we have access to toString.
    @Override
    public String toString() {
        return "This Dog is called "+this.getName()+" and it weighs "+this.getWeight()+" and is "+this.getAge()+" years old";
    }
    

    
    
}
