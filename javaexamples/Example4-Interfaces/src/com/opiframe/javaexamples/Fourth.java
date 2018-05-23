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
public class Fourth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MyInterfaceImpl implementation = new MyInterfaceImpl();
       System.out.println("5+10 = "+implementation.add(5, 10));
       System.out.println("5-10 = "+implementation.substract(5, 10));
    }
    
}
