package com.opiframe.java.helloworld;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Opiframe
 */
@Named(value = "helloWorld")
@RequestScoped
public class HelloWorld {
    
    private String name;

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
        this.name = "Oula";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }  
    
}
