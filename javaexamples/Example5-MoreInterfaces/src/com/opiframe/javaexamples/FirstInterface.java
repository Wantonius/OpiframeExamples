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

// In this example we inherit an another interface. Reason for doing this is relatively simple.
// You should ALWAYS write your code in a way that causes least amount of disruptions to code
// that uses your code when you have to make a change. Let's say that some people have been
// using our "InheritedInterface" before. Now making changes to that interface would cause
// all code using that interface to fail. If we are looking to make changes that work with older
// code also we can create a new interface which inherits (extends) the old interface. New code is
// then instructed to use the new interface and old code can continue using the old interface without
// disruptions.

public interface FirstInterface extends InheritedInterface {
    
    public String helloFromFirstInterface();
}
