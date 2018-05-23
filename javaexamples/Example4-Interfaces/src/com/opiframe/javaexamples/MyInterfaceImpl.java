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

//This class implements our interface MyInterface. Keyword is "implements". You can implement as many interfaces as you
//want. Just separate the interfaces after implements with a comma like "implements MyInterface, MyInterface2, ..." and so on.
//Declaring that you implement an interface makes the system force you to implements the abstract methods declared in the interface.

//Interfaces also create a type like class. Objects created from this class are of types "com.opiframe.javaexamples.MyInterfaceImpl", 
//"com.opiframe.javaexamples.MyInterface" and "java.lang.Object" as all classes inherit atleast Object-class.

public class MyInterfaceImpl implements MyInterface {

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int substract(int a, int b) {
        return a-b;
    }
    
}
