///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.opiframe.java.ReactiveCarShop;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
///**
// *
// * @author Oula
// */
//@Configuration
//@EnableReactiveMongoRepositories
//@PropertySource("classpath:application.properties")
//public abstract class MongoConf extends AbstractReactiveMongoConfiguration {
//
//    @Value("${spring.data.mongodb.database}")
//    private String database;
//    
//    @Override
//    protected String getDatabaseName(){
//        return database;
//    }
//    
//    @Bean
//    public MongoClient mongoClient(){
//        return MongoClients.create("mongodb://127.0.0.1:27017");
//    }
//}
