/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.studentlist;

import com.opiframe.java.studentlist.ejb.StudentEjb;
import com.opiframe.java.studentlist.model.Student;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Opiframe
 */
@Named(value = "controller")
@RequestScoped
public class Controller {
  
  @EJB StudentEjb ejb;
  
  private String firstName;
  private String lastName;
  
  /**
   * Creates a new instance of Controller
   */
  public Controller() {
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the studentList
   */
  public List<Student> getStudentList() {
    return ejb.findAll();
  }
 
  public void addStudent(){
    Student stdTemp = new Student();
    stdTemp.setFirstName(firstName);
    stdTemp.setLastName(lastName);
    
    ejb.addStudent(stdTemp);
    this.firstName = "";
    this.lastName = "";
  }
  
  public void removeStudent(Student student){
    ejb.removeStudent(student);
  }
}
