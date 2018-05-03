/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.actionlistener;

import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Opiframe
 */
@Named(value = "myBean")
@SessionScoped
public class MyBean implements Serializable {
  
  private String outcome = "";
  private final Rectangle marioRect = new Rectangle(1250,0,1250,2188);
  private final Rectangle luigiRect = new Rectangle(0,0,1250,2188);
  
  /**
   * Creates a new instance of MyBean
   */
  public MyBean() {
  }
  
  public void handleMouseClick(ActionEvent e){
    FacesContext context = FacesContext.getCurrentInstance();
    String clientId = e.getComponent().getClientId(context);
    Map<String, String> requestParams =
            context.getExternalContext().getRequestParameterMap();
    int x = new Integer((String)requestParams.get(clientId+".x"));
    int y = new Integer((String)requestParams.get(clientId+".y"));
    if(luigiRect.contains(new Point(x,y))){
      this.outcome = "luigi";
    }
    if(marioRect.contains(new Point(x,y))){
      this.outcome = "mario";
    }
  }  
  
  public String navigate(){
    return this.outcome;
  }
}
