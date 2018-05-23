/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Opiframe
 */
@FacesConverter("com.opiframe.java.converter.CustomConverter")
public class CustomConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    System.out.println("Input from the user: " + value);
    System.out.println("Converting value from component: " + component.getId());
    return "This is a fixed value";
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    String output = (String)value;
    return output;
  }
  
}
