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
public interface Listener {
    
    /*
    Here we have our two listener methods. Update is used by the Message to notify Listener about the update that has come
    setMessage allows us to bind the Message with the Listener.
    
    */
    
    public void update();
    public void setMessage(Message message);
    public String getName();
}
