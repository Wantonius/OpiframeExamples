/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.opiframe.contactlist.contactlist.domain.Contact;
import com.opiframe.contactlist.contactlist.domain.IContactRepository;
import com.opiframe.contactlist.contactlist.domain.IUserRepository;
import com.opiframe.contactlist.contactlist.domain.User;

/**
 *
 * @author Opiframe
 */
@Service
public class ContactService {

  @Autowired
  private IContactRepository repo;

  @Autowired
  private IUserRepository userRepo;

  public List<Contact> findByLastName(String lastName) {
    return repo.findByLastName(lastName);
  }

  public List<Contact> findByFirstName(String firstName) {
    return repo.findByFirstName(firstName);
  }

  public List<Contact> findByEmail(String email) {
    return repo.findByEmail(email);
  }

  public List<Contact> findByAge(Integer greaterThan, Integer lessThan) {
    return repo.findByAge(greaterThan, lessThan);
  }

  public boolean addContact(Contact contact) {
    try {
      repo.save(contact);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public boolean deleteAll() {
    try {
      repo.deleteAll();
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public boolean addUser(User user) {
    try {
      System.out.println("service addUser");
      userRepo.save(user);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public User findUser(User user) {
    User tmpUser = new User();
    try{
      tmpUser = userRepo.findByUserName(user.getUserName());
    } catch (Exception e){
      return null;
    }
    return tmpUser;
  }
  
  public Contact updateContact(Contact contact){
    return repo.updateContact(contact);
  }
}
