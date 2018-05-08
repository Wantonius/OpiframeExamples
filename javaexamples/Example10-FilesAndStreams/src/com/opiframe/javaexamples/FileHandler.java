/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Erno Hentonen
 */

/* This class handles ALL file communication. We will have two types of files.
   In one we will have ordinary text and we can read and write to it.
   In other we will save objects and read them back.

*/
public class FileHandler {
    
    private BufferedReader reader;
    private FileReader fr;
    private FileWriter fw;
    private FileInputStream in;
    private FileOutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private BufferedWriter writer; 
    private File file;
    private File binaryFile;
    private String fileName;
    private String binaryName;
    
    public FileHandler() {
        fileName = "C:\\temp\\test.txt";
        binaryName = "C:\\temp\\binarytest";
    }
    
    public FileHandler(String fileName, String binaryName) {
        this.fileName = fileName;
        this.binaryName = binaryName;
    }
    
    // This method opens the text file for writing. It is simpler to 
    // stay above the file if you open it for writing or reading only.
    // There are concerns with the operating system itself that are
    // beyond this course.
    
    public boolean openNormalFileForWriting() {
        logThis("OpenNormalFileForWriting","Beginning!");
        try {
            file = new File(fileName);
            if (!file.exists()) {
                
                file.createNewFile();
                logThis("OpenNormalFileForWriting","Creating File");
            }

            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;       
    }
   
    // This method opens the text file for reading. It is simpler to 
    // stay above the file if you open it for writing or reading only.
    // There are concerns with the operating system itself that are
    // beyond this course.
    public boolean openNormalFileForReading() {
        logThis("OpenNormalFileForReading","Beginning!");
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                logThis("OpenNormalFileForReading","Creating File");
            }

            fr = new FileReader(file);
            reader = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;     
    }
    
    // This method opens the binary file for reading. It is simpler to 
    // stay above the file if you open it for writing or reading only.
    // There are concerns with the operating system itself that are
    // beyond this course.
    public boolean openBinaryFileforReading() {
         logThis("OpenBinaryFileForReading","Beginning!");
        try {
            binaryFile = new File(binaryName);
            if (!file.exists()) {
                file.createNewFile();
                logThis("OpenBinaryFileForReading","Created binary file");
            }
            in = new FileInputStream(binaryFile);

            ois = new ObjectInputStream(in);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
        
    // This method opens the binary file for writing. It is simpler to 
    // stay above the file if you open it for writing or reading only.
    // There are concerns with the operating system itself that are
    // beyond this course.
     public boolean openBinaryFileforWriting() {
         logThis("OpenBinaryFileForWriting","Beginning");
         try {
            binaryFile = new File(binaryName);
            if (!file.exists()) {
                file.createNewFile();
                logThis("OpenBinaryFileForWriting","Created binary file");
            }
            out = new FileOutputStream(binaryFile);

            oos = new ObjectOutputStream(out);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }   
     
        
    // This method reads one line from the text file and returns it to caller
    public String readLineFromNormalFile() {
        logThis("readLineFromNormalFile","Beginning");
        String temp = "";
        try {
            temp = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
       // This method reads one object from the binart file and returns it to caller 
    public Object readFromBinaryFile() {
        logThis("readFromBinaryFile","Beginning");
        Object temp = null;
        try {
            temp = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return temp;
        }
        return temp;
    }
    

    // This method serializes one object and writes it to the binary file.
    public boolean writeToBinaryFile(Object object) {
        logThis("writeToBinaryFile","Beginning");
        try {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    //This method writes a line to the text file. If you want to save multiple lines use BufferedWriters append-method.
    
    public boolean writeLineToNormalFile(String line) {
        logThis("writeLineToNormalFile","Beginning");
        try {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    // This closes normal file writer stream
    public boolean closeNormalFileFromWriting() {
        logThis("closeNormalFileFromWriting","Beginning");
        try {
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // This closes normal file read stream
    public boolean closeNormalFileFromReading() {
        logThis("closeNormalFileFromReading","Beginning");
            try {
             
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
       // This closes binary file write stream 
    public boolean closeBinaryFileFromWriting() {
        logThis("closeBinaryFileFromWriting","Beginning");
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    // This closes binary file read stream
    public boolean closeBinaryFileFromReading() {
         logThis("closeBinaryFileFromReading","Beginning");
         try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }   
    // A private log function to easy logging.
     private void logThis(String tag, String log) {
         System.out.println("In "+ tag+ " doing "+log);
     }
}


    
         
    
    

