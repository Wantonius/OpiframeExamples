/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.studentlist.ejb;

import com.opiframe.java.studentlist.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Opiframe
 */
@Stateless
public class StudentEjb {
  
  @PersistenceContext EntityManager em;
  
  public List<Student> findAll(){
    return em.createQuery("SELECT e FROM Student e").getResultList();
  }
  
  public void addStudent(Student student){
    em.persist(student);
  }
  
  public void removeStudent(Student student){
    Student temp = em.find(Student.class, student.getStudentId());
    em.remove(temp);
  }  
}
