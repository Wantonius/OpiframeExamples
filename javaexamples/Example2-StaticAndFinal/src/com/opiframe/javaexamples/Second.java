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
public class Second {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //First lets access the static method and the constant within the StaticTesting class.
        System.out.println("The constant is "+StaticTesting.CONSTANT);
        System.out.println("The class variable is at:"+StaticTesting.thisCanBeAccessedBeforeNewIsCalled());
        //Lets add one to the class variable and call for it again
        StaticTesting.classVariable++;
        System.out.println("The class variable is at:"+StaticTesting.thisCanBeAccessedBeforeNewIsCalled());
        //Lets create a couple of objects from StaticTesting class
        
        StaticTesting test1 = new StaticTesting();
        StaticTesting test2 = new StaticTesting();
        
        //You can access class variables through objects of the class but it is not the common way. As an example we do it
        test1.classVariable++;
        System.out.println("The class variable is at (called from object test1):"+test1.thisCanBeAccessedBeforeNewIsCalled()); 
        System.out.println("The class variable is at (called from object test2):"+test2.thisCanBeAccessedBeforeNewIsCalled()); 
        
        //Lets change the instanceVariable of test1 and call for it in test1 and test2
        
        test1.setInstanceVariable(10);
        System.out.println("The instance variable of test1: "+test1.getInstanceVariable());
        System.out.println("The instance variable of test2: "+test2.getInstanceVariable());
        
        //Remove the comment from the next line and try to compile the code. It ain't gonna work because we try to change a final variable.
        //test1.setThis=10;
    }
}
