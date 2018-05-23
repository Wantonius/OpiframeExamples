/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author Opiframe
 */
public class IContactRepositoryImpl implements ICustomContactRepository {

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public Contact updateContact(Contact contact) {
    Query query = new Query();
    query.addCriteria(Criteria.where("contactId").is(contact.getContactId()));
    Update update = new Update();
    update.set("firstName",contact.getFirstName());
    update.set("lastName",contact.getLastName());
    update.set("email",contact.getEmail());
    update.set("phoneNumber",contact.getPhoneNumber());
    update.set("age",contact.getAge());
    mongoTemplate.updateFirst(query, update, "contact");
    System.out.println("Moi id: " + contact.getContactId());
    
    Contact newContact = mongoTemplate.findOne(query, Contact.class, "contact");
    return newContact;
  }

}
