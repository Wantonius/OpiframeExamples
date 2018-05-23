/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

/**
 *
 * @author JIMMS-USER
 */
public class Fifth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OldImplementation old = new OldImplementation();
        // Note "new" is a reserved word in most object-oriented languages
        NewImplementation newimpl = new NewImplementation();
        
        System.out.println(old.helloFromInheritedInterface());
        System.out.println(newimpl.helloFromInheritedInterface());
        System.out.println(newimpl.helloFromFirstInterface());
        System.out.println(newimpl.helloFromSecondInterface());
    }
    
}
