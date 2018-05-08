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
// Now this class is of type "NewImplementation","FirstInterface","SecondInterface","InheritedInterface" and "Object"
public class NewImplementation implements FirstInterface,SecondInterface {

    @Override
    public String helloFromFirstInterface() {
         return "Hello from FirstInterface with New Implementation";
    }

    // NOTE!!!!!
    // Since the FirstInterface extended the InheritedInterface we need to implement methods from BOTH interfaces. 
    @Override
    public String helloFromInheritedInterface() {
         return "Hello from InheritedInterface with New Implementation";
    }

    // Here is the SecondInterface. 
    @Override
    public String helloFromSecondInterface() {
         return "Hello from SecondInterface with New Implementation";
    }
    
}
