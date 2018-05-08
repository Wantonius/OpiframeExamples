/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

/**
 *
 * @author JIMMS-USER
 */
public class NumberTooLargeException extends Exception {
    
    private int largestNumber;
    
    public NumberTooLargeException() {
        this.largestNumber = 0;
    }
   
    public NumberTooLargeException(int largestNumber) {
        this.largestNumber = largestNumber;
    }
    
    public int getLargestNumber() {
        return this.largestNumber;
    }
}
