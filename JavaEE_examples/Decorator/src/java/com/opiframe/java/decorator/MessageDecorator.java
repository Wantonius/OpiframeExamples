/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author Opiframe
 */
@Decorator
public class MessageDecorator implements IMessage {
  
  @Inject @Delegate @Any @MessageQualifier IMessage message;
  
  @Override
  public String deliverMessage(String target) {
    return message.deliverMessage(target + " this part comes from decorator");
  }  
}
