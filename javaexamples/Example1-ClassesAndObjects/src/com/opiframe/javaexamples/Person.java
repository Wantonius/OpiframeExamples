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

// This is our own class. We give it a couple of member fields like a String for name and an Integer for age. We will also provide
// a couple of constructors and setters and getters to access member fields.

public class Person {
    
    //These are variables or members. The keyword "private" means that no other object has direct access to these variables from outside.
    //We will provide two functions for each member. One to set the value of the variable and other to retrieve or get it. This is a standard
    //way in object-oriented programming. This technique is called _encapsulation_ and it is central to the tenents of object-oriented programming.
    
    private String name;
    private int age;

    //Next we will provide two constructors. One so called blank constructor that does essentially nothing but instantiates an object to initial values.
    //In Java all basic variables have an initial value. For int it is 0 and for String it is "". This is not true for other object-oriented languages
    //so be carefu. The other constructor will set the initial state to what is passed to it as parameters.
    
    //Note that constructors NEVER have a return value. It instantiates an object and is basically never called directly.
    
    //The basic constructor
    public Person() {
        
    } 
    //More complex constructor. 
    public Person(String name, int age) {
        //We set our variables to initial values. Note the keyword "this". It represents the object itself. It can be used within the object code
        //to represent the object itself. Very useful! In this case "this.name" is the variable name that we declared in the beginning and the "name" after
        //the equal sign is the name parameter from the constructor. This is called "variable shadowing". It means that variable with a same name 
        //exists atleast twice with in the same scope. Scope is generated with curly brackets {}. So the biggest scope is the class itself. And all the
        //fields have been declared there. So these variables exist for every member, function and scope within the class. Now the constructor forms another
        //scope within the classes scope and the parameters age and name exist only within that scope. The smaller scope ALWAYS gets a 
        //first go so if we want to refer to the variables in the whole class scope we use keyword "this".
        
        this.name = name;
        this.age = age;
        
    }
        /**
     * @return the name
     */
    
    //This is a typical function within a class. It has an access modifier (public, protected, <no modifier> or private), a return value (String)
    //and a name for the function. This function is available for anyone to use from outside of the class. Also it has a concrete return value.
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    
    //Here is another typical function. Again the access modifier is public so anyone can use this. The return value is "void" meaning that
    //this function doesn't return anything. Only constructors have NO word where the return value should be. If you have no return value use "void".
    //This function also gets one parameter of String type. Again note the use of "this" within the function since the name variable has been shadowed.
    
    public void setName(String name) {
        this.name = name;
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
