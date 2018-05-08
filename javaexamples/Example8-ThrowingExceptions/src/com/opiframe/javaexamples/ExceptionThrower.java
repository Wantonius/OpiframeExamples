/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Erno Hentonen
 */


public class ExceptionThrower {
 
    // This is a way to move the exception higher up in the food chain
    // This method throws FileNotFoundException when FileReader is accessed
    // We need to handle the exception in main!
    public FileReader openFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        return fr;
        
    }
    // Of course normally we would throw the exception only in special cases
    // when something doesn't add up. This is a useless method but demonstrates
    // how to throw exceptions.
    public void throwException() throws IOException {
        throw new IOException();
    }
}
