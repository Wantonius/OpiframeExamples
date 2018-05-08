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
public class MyListener implements Listener{

    private String name;
    private Message myMessage;
    
    public MyListener(){
        
    }
    
    public MyListener(String name) {
        this.name = name;
    }
    
    @Override
    public void update() {
        String message = (String) myMessage.getMessage();
        System.out.println(this.name+" got a new message and it is: "+message);
    }

    @Override
    public void setMessage(Message message) {
       this.myMessage = message;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
