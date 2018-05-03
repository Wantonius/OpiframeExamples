/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.converter;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Opiframe
 */
@Named(value = "myBean")
@SessionScoped
public class MyBean implements Serializable {
  private String field;
  private CustomConverter customConverter;
  private MyPhaseListener myPhaseListener;
  
  /**
   * Creates a new instance of MyBean
   */
  public MyBean() {
  }

  public String submit(){
    System.out.println(this.getField());
    return null;
  }
  /**
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * @param field the field to set
   */
  public void setField(String field) {
    this.field = field;
  }

  /**
   * @return the customConverter
   */
  public CustomConverter getCustomConverter() {
    return customConverter;
  }

  /**
   * @param customConverter the customConverter to set
   */
  public void setCustomConverter(CustomConverter customConverter) {
    this.customConverter = customConverter;
  }

  /**
   * @return the myPhaseListener
   */
  public MyPhaseListener getMyPhaseListener() {
    return myPhaseListener;
  }

  /**
   * @param myPhaseListener the myPhaseListener to set
   */
  public void setMyPhaseListener(MyPhaseListener myPhaseListener) {
    this.myPhaseListener = myPhaseListener;
  }
  
}
