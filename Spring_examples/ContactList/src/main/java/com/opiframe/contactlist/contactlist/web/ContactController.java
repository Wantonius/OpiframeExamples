/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.web;

import com.opiframe.contactlist.contactlist.domain.Contact;
import com.opiframe.contactlist.contactlist.domain.User;
import com.opiframe.contactlist.contactlist.service.ContactService;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Opiframe
 */
@RestController
public class ContactController {

  @Autowired
  private ContactService service;

  @RequestMapping(value = "api/contact", method = RequestMethod.GET)
  public @ResponseBody
  List<Contact> find(@RequestParam("search") String search, @RequestParam("value") String value) {
    if (search.contentEquals("lastName")) {
      return service.findByLastName(value);
    }
    if (search.contentEquals("firstName")) {
      return service.findByFirstName(value);
    }
    if (search.contentEquals("email")) {
      return service.findByEmail(value);
    }
    return null;
  }

  @RequestMapping(value = "api/contact/age", method = RequestMethod.GET)
  public @ResponseBody
  List<Contact> findByAge(@RequestParam("gt") Integer lowerLimit, @RequestParam("lt") Integer upperLimit) {
    return service.findByAge(lowerLimit, upperLimit);
  }

  @RequestMapping(value = "api/contact", method = RequestMethod.POST)
  public ResponseEntity<Contact> addContact(@RequestParam("mode") String mode, @RequestBody Contact contact) {
    System.out.println("Contact id: " + contact.getContactId());
    
    if (mode.equals("add")) {
      System.out.println("addContact add");
      Random random = new Random();
      Long id = random.nextLong();
      contact.setContactId(id.toString());
      if (service.addContact(contact)) {
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
      }
    } else if (mode.equals("edit")) {
      System.out.println("Addcontact edit");
      Contact tmpContact = service.updateContact(contact);
      return new ResponseEntity<Contact>(tmpContact, HttpStatus.OK);
    }  
    return new ResponseEntity(HttpStatus.CONFLICT);
  }

  @RequestMapping(value = "api/contact", method = RequestMethod.DELETE)
  public @ResponseBody
  String deleteAll() {
    service.deleteAll();
    return "{'Status':'Success'}";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<String> login(@RequestBody User user) {
    User tmpUser = service.findUser(user);
    if (tmpUser != null) {
      if (tmpUser.getPassword().contentEquals(user.getPassword())) {
        return new ResponseEntity<String>("{\"authtoken\":\"123\"}", HttpStatus.OK);
      }
    }
    return new ResponseEntity(HttpStatus.FORBIDDEN);
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity<User> register(@RequestBody User user) {
    System.out.println("Controller register");
    Random random = new Random();
    Long id = random.nextLong();
    user.setId(id);
    if (service.addUser(user)) {
      return new ResponseEntity<User>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.CONFLICT);
    }
  }
}
