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
public class Third {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        //Let's try to create an instance of Mammal, an abstract class
        //Remove the comment from next line to see the error.
        //Mammal mammal = new Mammal();
        System.out.println("The animal farm!!");
        dog.setAge(5);
        dog.setName("Woofie");
        dog.setWeight(10.0);
        cat.setAge(3);
        cat.setName("Morris");
        cat.setWeight(5.0);
        
        System.out.println(dog.toString());
        dog.makeNoise();
        System.out.println("Is this mammal a dog:"+Mammal.isThisMammalADog(dog));
        System.out.println("------------------------");
        System.out.println(cat.toString());
        cat.makeNoise();
        System.out.println("Is this mammal a dog:"+Mammal.isThisMammalADog(cat));
               
    }
    
}
