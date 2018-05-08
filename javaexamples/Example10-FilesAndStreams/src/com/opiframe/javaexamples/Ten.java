/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.util.Scanner;

/**
 *
 * @author Erno Hentonen
 */
public class Ten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();
        filehandler.openNormalFileForWriting();
        filehandler.writeLineToNormalFile("Moi Moi moi!\n");
        filehandler.closeNormalFileFromWriting();
        filehandler.openNormalFileForReading();
        System.out.println(filehandler.readLineFromNormalFile());
        filehandler.closeNormalFileFromReading();
        
        //Moving on to the binary file. First we create an object, save it to disk and
        //move on to read it back to different handle and the print out the message.
        //Lets use the Scanner to read input from the user and save that as the message!
        //System.in is the usual input source (typically keyboard) for this JVM.
        
        SavedObject object = new SavedObject();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write message to the object:");
        object.setMessage(scanner.nextLine());
        filehandler.openBinaryFileforWriting();
        filehandler.writeToBinaryFile(object);
        filehandler.closeBinaryFileFromWriting();
        
        filehandler.openBinaryFileforReading();
        SavedObject temp = (SavedObject)filehandler.readFromBinaryFile();
        filehandler.closeBinaryFileFromReading();
        System.out.println("Saved Object message: "+temp.getMessage());

    }
    
}
