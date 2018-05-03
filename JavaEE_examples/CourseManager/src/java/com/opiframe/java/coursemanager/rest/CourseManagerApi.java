/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.coursemanager.rest;

import com.opiframe.java.coursemanager.ejb.CourseManager;
import com.opiframe.java.coursemanager.models.Course;
import com.opiframe.java.coursemanager.models.Room;
import com.opiframe.java.coursemanager.models.Student;
import com.opiframe.java.coursemanager.models.Teacher;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Opiframe
 */
@Path("coursemanager")
public class CourseManagerApi {
  @EJB CourseManager manager;
    
  @Context
  private UriInfo context;

  /**
   * Creates a new instance of CourseManagerApi
   */
  public CourseManagerApi() {
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("student")
  public List<Student> getStudent() {
    //TODO return proper representation object
    return manager.findStudents();
  }

  @POST
  @Path("student")
  @Consumes(MediaType.APPLICATION_JSON)
  public void postStudent(Student student) {
    manager.addStudent(student);
  }
  
  @DELETE
  @Path("student")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteStudent(Student student){
    manager.removeStudent(student);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("teacher")
  public List<Teacher> getTeacher() {
    //TODO return proper representation object
    return manager.findTeachers(0);
  }

  @POST
  @Path("teacher")
  @Consumes(MediaType.APPLICATION_JSON)
  public void postTeacher(Teacher teacher) {
    manager.addTeacher(teacher);
  }
  
  @DELETE
  @Path("teacher")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteTeacher(Teacher teacher){
    manager.removeTeacher(teacher);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("room")
  public List<Room> getRoom() {
    //TODO return proper representation object
    return manager.findRooms("");
  }

  @POST
  @Path("room")
  @Consumes(MediaType.APPLICATION_JSON)
  public void postRoom(Room room) {
    manager.addRoom(room);
  }
  
  @DELETE
  @Path("room")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteRoom(Room room){
    manager.removeRoom(room);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("course")
  public List<Course> getCourses() {
    //TODO return proper representation object
    return manager.findCourses("");
  }

  @POST
  @Path("course")
  @Consumes(MediaType.APPLICATION_JSON)
  public void postCourse(Course course) {
    manager.addCourse(course);
  }
  
  @DELETE
  @Path("course")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteCourse(Course course){
    manager.removeCourse(course);
  }
  
}
