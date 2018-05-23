/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.datatable;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Opiframe
 */
@Named(value = "dataTableBean")
@SessionScoped
public class DataTableBean implements Serializable {

  private List<Contact> contactList = new ArrayList<>();
  private Contact contact;
  private boolean hidden;

  /**
   * Creates a new instance of DataTableBean
   */
  public DataTableBean() {
    this.contact = new Contact();
    this.hidden = false;
  }

  /**
   * @return the contactList
   */
  public List<Contact> getContactList() {
    return contactList;
  }

  /**
   * @param contactList the contactList to set
   */
  public void setContactList(List<Contact> contactList) {
    this.contactList = contactList;
  }

  /**
   * @return the contact
   */
  public Contact getContact() {
    return contact;
  }

  /**
   * @param contact the contact to set
   */
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public void addContact() {    
    this.contactList.add(this.contact);
    this.contact = new Contact();
    
    if (this.contactList.size() > 0) {
      this.hidden = true;
    }
  }

  public void deleteContact(Contact contact) {
    if (this.contactList.contains(contact)) {
      this.contactList.remove(contact);
      
      if (this.contactList.size() == 0) {
        this.hidden = false;
      }
    }
  }

  /**
   * @return the hidden
   */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * @param hidden the hidden to set
   */
  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }
}
