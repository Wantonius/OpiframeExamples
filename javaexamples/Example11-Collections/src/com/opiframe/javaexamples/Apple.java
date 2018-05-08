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
 */
public class Apple implements Serializable {
    
    public static final String COLOR_RED = "red";
    public static final String COLOR_GREEN = "green";
    public static final String COLOR_BROWN= "brown";   
    
    private String color;

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    public String toString() {
        return "Color of this apple "+this.color;
    }
    
}
