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
public class Eleven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Storage storage = new Storage();
        Apple redapple = new Apple();
        Apple greenapple = new Apple();
        Apple brownapple = new Apple();
        redapple.setColor(Apple.COLOR_RED);
        greenapple.setColor(Apple.COLOR_GREEN);
        brownapple.setColor(Apple.COLOR_BROWN);
        storage.addAnApple(redapple);
        storage.addAnApple(brownapple);
        storage.addAnApple(greenapple);
        
        System.out.println("Printing apple list "+storage.getAppleList().toString());
        
        storage.eatAnApple();
        storage.eatAnApple();
        storage.eatAnApple();
        storage.eatAnApple();
        
        Car audi = new Car();
        Car bmw = new Car();
        Car honda = new Car();
        audi.setType(Car.AUDI);
        bmw.setType(Car.BMW);
        honda.setType(Car.HONDA);
        audi.setLicensePlate("AAA-111");
        bmw.setLicensePlate("BBB-222");
        honda.setLicensePlate("CCC-333");
        storage.storeACar(audi);
        storage.storeACar(bmw);
        storage.storeACar(honda);
        
        System.out.println("Printing out car map "+storage.getCarStorage().toString());
        
        storage.getACar("AAA-111");
        
        System.out.println("Printing out car map "+storage.getCarStorage().toString());
        
        storage.removeACar("BBB-222");
        
        System.out.println("Printing out car map "+storage.getCarStorage().toString());
        
    }
    
}
