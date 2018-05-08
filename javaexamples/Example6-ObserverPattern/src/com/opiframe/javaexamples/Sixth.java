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
public class Sixth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyMessage message = new MyMessage();
        MyListener listener1 = new MyListener("First");
        MyListener listener2 = new MyListener("Second");
        MyListener listener3 = new MyListener("Third");
        MyListener listener4 = new MyListener("Fourth");
        
        //Let's register our listeners!
        
        message.registerListener(listener1);
        message.registerListener(listener2);
        message.registerListener(listener3);
        message.registerListener(listener4);
        
        //Let's try to register listener1 again!
  
        message.registerListener(listener1);
        
        //Set message to all listeners.
        
        listener1.setMessage(message);
        listener2.setMessage(message);
        listener3.setMessage(message);
        listener4.setMessage(message);
        
        //Let's change the message on MyMessage
        
        message.postMessage("This is the first message!");
        message.notifyListeners();
        
        //Let's remove listener2 from the ListenerList and post a new message
        
        message.unregisterListener(listener2);
        message.postMessage("This is the second message!!");
        message.notifyListeners();
        
    }
    
}
