/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Opiframe
 */
@Configuration
public class ContactMongoConfiguration {
  public @Bean MongoTemplate mongoTemplate() throws Exception{
    MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"),"contactlistdb");
    return mongoTemplate;
  }
}
