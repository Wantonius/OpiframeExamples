/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.coursemanager.ejb;

import com.opiframe.java.coursemanager.models.Course;
import com.opiframe.java.coursemanager.models.Room;
import com.opiframe.java.coursemanager.models.Student;
import com.opiframe.java.coursemanager.models.Teacher;
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
public class CourseManager {

  @PersistenceContext
  EntityManager em;

  public List<Room> findRooms(String name) {
    if ("".equals(name)) {
      return em.createQuery("SELECT e FROM Room e").getResultList();
    } else {
      return em.createQuery("SELECT e FROM Room e WHERE e.name LIKE :name")
              .setParameter("name", name)
              .getResultList();
    }
  }
  
  public void addRoom(Room room){
    em.persist(room);
  }
  
  public void removeRoom(Room room){
    Room tempRoom = em.find(Room.class, room.getId());
    em.remove(tempRoom);
  }
  
  public List<Teacher> findTeachers(int id) {
    System.out.println("id: " + id);
    if (id == 0) {
      return em.createQuery("SELECT e FROM Teacher e").getResultList();
    } else {
      Teacher temp = em.find(Teacher.class, (long)id);
      List<Teacher> tempList = new ArrayList<>();
      tempList.add(temp);
      return tempList;
    }
  }
  
  public void addTeacher(Teacher teacher){
    em.persist(teacher);
  }
  
  public void removeTeacher(Teacher teacher){
    Teacher tempTeacher = em.find(Teacher.class, teacher.getId());
    em.remove(tempTeacher);
  }
  
  public void addCourse(Course course){
    em.persist(course);
  }
  
  public void removeCourse(Course course){
    Course tempCourse = em.find(Course.class, course.getId());
    em.remove(tempCourse);
  }
  
  public List<Course> findCourses(String courseName){
    if ("".equals(courseName)) {
      return em.createQuery("SELECT e FROM Course e").getResultList();
    } else {
      return em.createQuery("SELECT e FROM Course e WHERE e.name LIKE :name")
              .setParameter("name", courseName)
              .getResultList();
    }    
  }
  
  public void addStudent(Student student){
    em.persist(student);
  }
  
  public void removeStudent(Student student){
    Student tempStd = em.find(Student.class, student.getId());
    em.remove(tempStd);
  }
  
  public List<Student> findStudents(){
    return em.createQuery("SELECT e FROM Student e").getResultList();
  }
}
