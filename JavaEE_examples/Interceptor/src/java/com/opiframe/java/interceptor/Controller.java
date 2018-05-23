/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.interceptor;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Opiframe
 */
@Named(value = "controller")
@RequestScoped
public class Controller {
  
  private String message;
  
  @Inject MessageService messageService;
  
  /**
   * Creates a new instance of Controller
   */
  public Controller() {
  }

  /**
   * @return the message
   */
  public String getMessage() {    
    return messageService.getMessage();
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    messageService.setMessage(message);
  }
  
}
