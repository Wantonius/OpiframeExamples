/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Erno Hentonen
 */
public class Eight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExceptionThrower ex = new ExceptionThrower();
        
        try {
            ex.openFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
        
        try {
            ex.throwException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
