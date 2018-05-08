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
public class Car implements Serializable {
    
    public static final String AUDI = "Audi";
    public static final String BMW = "BMW";
    public static final String HONDA= "Honda";   
    
    private String type;
    private String licensePlate;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String toString() {
        return this.type+" with licenseplate "+this.licensePlate;
    }
}
