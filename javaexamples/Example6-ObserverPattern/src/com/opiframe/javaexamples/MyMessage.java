/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.javaexamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erno Hentonen
 */
public class MyMessage implements Message {

    //NOTE: We are using a Collection called List. List is the interface type of a Collection and ArrayList is an implementation
    //No need to know anything else right now except that you can store, sort and remove objects from a List. We store our Listeners
    //that register in a List for convenience.
    
    private List<Listener> myListenerList = new ArrayList<>();
    private String message;
    private boolean changed;
    
    @Override
    public boolean registerListener(Listener listener) {
        // Let's check if we already have registered. If we have, let's not register again!
        if (!myListenerList.contains(listener)) {
            System.out.println("Registering Listener:"+listener.getName());
            myListenerList.add(listener);
            return true;
        }
        return false;
    }

    @Override
    public boolean unregisterListener(Listener listener) {
        //We do not need to check if the listener is in the List. That is done automatically by the List code when we remove stuff.
        System.out.println("Unregistering Listener:"+listener.getName());
        myListenerList.remove(listener);
        return true;
    }

    @Override
    public void notifyListeners() {
        // If the message has changed since we last notified everybody we go on. Otherwise there is no point in notifying anyone.
        if (changed) {
            System.out.println("Notifying listeners about a new message!");
            this.changed = false;
            //This is known as for-each loop. It is more powerful than ordinary for-loop. Use this with Lists and Collections!!
            myListenerList.stream().forEach((listener) -> {
                listener.update();
            });
        }
    }

    @Override
    public Object getMessage() {
        return message;
    }
    
    public void postMessage(String message) {
        // When a new message is posted we change the changed state to "true". This is then changed back to false when we notify listeners.
        System.out.println("New message posted: "+ message);
        this.message = message;
        this.changed = true;
    }
}
