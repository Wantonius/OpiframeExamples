/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Opiframe
 */
public interface IUserRepository extends MongoRepository<User,Long> {
  public User findById(Long id);
  public User findByUserName(String userName);
}
