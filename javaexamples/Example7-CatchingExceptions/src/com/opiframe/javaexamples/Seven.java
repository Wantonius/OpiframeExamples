/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Erno Hentonen
 */
public class Seven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //trying to open non-existent file
        try {
            File file = new File("test.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File test.txt not found!");
            
        }
        //Catching multiple potential exceptions. Filereader wants FileNotFoundException to be handled 
        //BufferedReader with readLine wants potential IOException to be handled.
        //Create a file test2.txt under C:\temp\ or change the path to appropriate!
        try {
            File file2 = new File("C:\\temp\\test2.txt");
            FileReader fr2 = new FileReader(file2);
            BufferedReader br = new BufferedReader(fr2);
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }  catch (IOException e) {
            System.out.println("Cannot read the file!");
        }
 
        //The Finally block is accessed by both try and catch blocks. So even if an exception is thrown
        //finally block is accessed. Use finally block to release locked resources that need to be released
        //even when an exception is thrown.
        
        try {
            File file3 = new File("test.txt");
            FileReader fr3 = new FileReader(file3);
        } catch (FileNotFoundException e) {
            System.out.println("File test.txt not found again!");
            //Most important DEBUG tool during development phase (these need to be removed from production ready stuff)
            //PrintStackTrace().
            e.printStackTrace();
        } finally {
            System.out.println("We access this even though FileNotFoundException is thrown");
         }
        
    }
}
