/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.decorator;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Opiframe
 */
@RequestScoped
@MessageQualifier
public class MessageGenerator implements IMessage {

  @Override
  public String deliverMessage(String target) {
    return "Hello, " + target;
  }  
}
