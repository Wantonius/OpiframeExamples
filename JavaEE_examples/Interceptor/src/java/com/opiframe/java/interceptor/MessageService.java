/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.interceptor;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Opiframe
 */
@SessionScoped
@InterceptorQualifier
public class MessageService implements Serializable {
  
  private String message;

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
