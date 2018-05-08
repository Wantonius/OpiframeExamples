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
public class StaticTesting {
    
    //The two keywords static and final play an important role when we need to change the behaviour of fields and methods.
    
    //static defines any variable as a class variable. It means that all instances of the class (OBJECTS!) share the same variable.
    //final defines any variable as non-changing. It can be set ONCE and never changed. So static and final create a class constant.
    
    public static final String CONSTANT = "ThisIsAConstant";
    public static int classVariable = 0;
    private int instanceVariable;
    public final int setThis;
    
    public StaticTesting()  {
        setThis = 0;
    }
    
    //Both static and final have more meaning. In Java you can have static nested classes (classes within classes). More on this later. Also
    //methods can be declared static. Basic rule is that static methods CAN be accessed even if there are no instanses of objects.
    //Also final carries different meaning when applied to class or a method. A final class CANNOT be inherited. String is an example of such
    //a class (http://docs.oracle.com/javase/6/docs/api/java/lang/String.html note the final keyword in the class declaration). A final method
    //cannot be overwritten (more on this later again). Object class has such methods, for example getClass<?> method
    //http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
    
    public static int thisCanBeAccessedBeforeNewIsCalled() {
        return classVariable;
    }

    /**
     * @return the instanceVariable
     */
    public int getInstanceVariable() {
        return instanceVariable;
    }

    /**
     * @param instanceVariable the instanceVariable to set
     */
    public void setInstanceVariable(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }
}
