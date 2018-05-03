/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.jaasauthentication;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Opiframe
 */
@Named(value = "backinBean")
@RequestScoped
public class BackinBean {
  @EJB SecureEjb ejb;
  private String info;
  /**
   * Creates a new instance of BackinBean
   */
  public BackinBean() {
  }

  /**
   * @return the info
   */
  public String getInfo() {
    String tmp = "";
    try{
      tmp = ejb.isAdmin();
    } catch(Exception e) {
      tmp = "Not admin";
    }
    return tmp;
  }

  /**
   * @param info the info to set
   */
  public void setInfo(String info) {
    this.info = info;
  } 
}
