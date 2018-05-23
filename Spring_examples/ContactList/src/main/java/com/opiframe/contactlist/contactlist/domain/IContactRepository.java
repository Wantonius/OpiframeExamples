/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.contactlist.contactlist.domain;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Opiframe
 */
public interface IContactRepository extends MongoRepository<Contact, Long>, ICustomContactRepository {

  public List<Contact> findByLastName(String lastName);

  public List<Contact> findByFirstName(String firstName);

  public List<Contact> findByEmail(String email);

  @Query("{age:{$gt:?0,$lt:?1}}")
  public List<Contact> findByAge(Integer greaterThan, Integer lessThan);
}
