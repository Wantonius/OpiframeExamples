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
public class Nine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TestingNumbers test = new TestingNumbers();
        test.setLargest(10);
        try {
        if (!test.testNumbers(5)) {
            System.out.println("Allowed number is bigger");
            System.out.println("-----------------------------------------------------");
        }
        } catch (NumberTooLargeException e) {
            System.out.println("Largest Number allowed is "+e.getLargestNumber());
            e.printStackTrace();
        }
       
        try {
        if (!test.testNumbers(11)) {
            System.out.println("Allowed number is bigger");
        }
        } catch (NumberTooLargeException e) {
            System.out.println("Largest Number allowed is "+e.getLargestNumber());
            e.printStackTrace();
        }
    }
    
}
