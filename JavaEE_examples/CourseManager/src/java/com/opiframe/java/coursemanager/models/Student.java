/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.coursemanager.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Opiframe
 */
@Entity
public class Student extends Person implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Embedded
  private Address address;
  @OneToMany
  private List<Course> courseList;
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Student)) {
      return false;
    }
    Student other = (Student) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.opiframe.java.coursemanager.models.Student[ id=" + id + " ]";
  }

  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * @return the courseList
   */
  public List<Course> getCourseList() {
    return courseList;
  }

  /**
   * @param courseList the courseList to set
   */
  public void setCourseList(List<Course> courseList) {
    this.courseList = courseList;
  }
  
}
