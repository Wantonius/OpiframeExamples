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
public class TestingNumbers {
    
    private int largest;

    
    public boolean testNumbers(int number) throws NumberTooLargeException {
        if (number > this.largest) {
            throw new NumberTooLargeException(this.largest);
        
        }
        return false;
    }
    
    /**
     * @return the largest
     */
    public int getLargest() {
        return largest;
    }

    /**
     * @param largest the largest to set
     */
    public void setLargest(int largest) {
        this.largest = largest;
    }
    
    
}
