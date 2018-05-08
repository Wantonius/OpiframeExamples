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

// This is a class. We declare a class using an access modifier (public, protected, <no-modifier>, private. More on this later)
// and using the keyword class. Classes in Java always begin with a capital letter. JavaSE programs MUST contain one and only one class with
// a static function called main with String array as parameter. This is used by the Java Engine as an entry point to your program. Typically this
// class has no other members or fields.

// Look at the Person class before continuing.

public class First {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // So lets create our first object!
        // First we declare type for our new variable. It is of course the class we are about to create an object from. So "Person"
        // Next we give the variable a name, "firstPerson". Finally we use the keyword new (common in most object-oriented languages)
        // to say that we are about to instantiate a new Person object and we refer to a specific constructor in Person class.
        
        Person firstPerson = new Person();
        
        //Lets use the setters from the class Person to set new values to the variables within that firstPerson object.
        firstPerson.setAge(20);
        firstPerson.setName("Jaska");
        
        //Now lets the other more complex constructor to create another Person object. 
        Person secondPerson = new Person("Matti",25);
        
        //Then we will proceed to call both objects and printing out their states. The call "print" in Java is in a system class and package
        //called System.Out. So
        System.out.println("Eka kaveri on "+firstPerson.getName());
        System.out.println(firstPerson.getName()+", ikä on "+firstPerson.getAge());
         System.out.println("Toka kaveri on "+secondPerson.getName());
        System.out.println(secondPerson.getName()+", ikä on "+secondPerson.getAge());      
        
        
    }
    
}
