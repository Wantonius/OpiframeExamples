/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.jaasauthentication;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Opiframe
 */
@DeclareRoles("ADMIN")
@RolesAllowed("ADMIN")
@Stateless
public class SecureEjb {

  public String isAdmin(){
    return "You are admin";
  }
  // Add business logic below. (Right-click in editor and choose
  // "Insert Code > Add Business Method")
}
