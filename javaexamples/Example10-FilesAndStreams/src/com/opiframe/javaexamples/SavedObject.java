/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.io.Serializable;

/**
 *
 * @author Erno Hentonen
 * 
 */

// Serializable is extremely important here. It is a special interface
// that doesn't need any implementation usually. But it is vital when
// you are trying to save or send objects somewhere. We will talk about
// serialization on the course. 


// On Serialization http://docs.oracle.com/javase/jndi/tutorial/objects/storing/serial.html

public class SavedObject implements Serializable {
    
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
