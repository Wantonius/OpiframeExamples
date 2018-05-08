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

/*
                    Observer Pattern

We are about to implement our first software design pattern. This is widely used in
almost every software. Especially GUI code uses this design pattern extensively. Most
buttons and such use observer pattern to observe clicks and taps. You have a subject
or a Message which you want to observe making changes. These observers or interested
parties in our Message are called Listeners in Java. We need to create two interfaces.
First we need an interface for the Message. This interface is implemented to give
the interested parties or Listeners a chance to register and unregister to be notified
of changes in this Message. 

The methods are:
    registerListener which registers a listener
    unregisterListener which unregisters a listener
    notifyListeners which notifies every registered listener
    getMessage is for those Listeners to get the message when notified of a change.


*/

public interface Message {
    
    public boolean registerListener(Listener listener);
    public boolean unregisterListener(Listener listener);
    public void notifyListeners();
    public Object getMessage();
}
