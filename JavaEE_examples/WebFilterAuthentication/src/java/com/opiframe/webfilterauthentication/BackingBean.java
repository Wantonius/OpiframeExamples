/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.webfilterauthentication;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Opiframe
 */
@Named(value = "backingBean")
@SessionScoped
public class BackingBean implements Serializable {
  
  private String userName, password;
  private List<User> userList = new ArrayList<>();
  /**
   * Creates a new instance of BackingBean
   */
  public BackingBean() {
    User test = new User();
    test.setUserName("test");
    test.setPassword("test");
    userList.add(test);
    
    User admin = new User();
    admin.setUserName("admin");
    admin.setPassword("admin");
    userList.add(admin);    
  }

  public String login(){
    for(User u: userList){
      if(u.getUserName().equals(this.userName)){
        if(u.getPassword().equals(this.password)){
          HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
          session.setAttribute("login", "login");
          return "secure";
        }
      }
    }
    return "index";
  }
  
  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
}
