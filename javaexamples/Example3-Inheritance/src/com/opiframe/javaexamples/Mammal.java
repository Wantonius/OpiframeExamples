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

// Mammal is one step above Animal since it is a smaller group of things. In our case
// all mammals have a name, they make noise and we can compare any mammal to see if it is a Dog!
public abstract class Mammal extends Animal {
    
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    // We will call super.makeNoise in both Cat and Dog and thus this method will be called.
    public void makeNoise() {
        System.out.println("The mammal is going to make noise");
    }
    
    // Mammal has a static test method for dogs. Note that both Cat and Dog are Mammal and thus can call this method. Dog will return true and Cat false.
    public static boolean isThisMammalADog(Mammal mammal) {
        if (mammal instanceof Dog) {
            return true;
        }
        return false;
    }
    
}
