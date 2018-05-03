/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.coursemanager;

import com.opiframe.java.coursemanager.ejb.CourseManager;
import com.opiframe.java.coursemanager.models.Address;
import com.opiframe.java.coursemanager.models.Course;
import com.opiframe.java.coursemanager.models.Room;
import com.opiframe.java.coursemanager.models.Student;
import com.opiframe.java.coursemanager.models.Teacher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Opiframe
 */


@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable {

  @EJB
  CourseManager cm;

  public static final int STUDENT_CHOICE = 1,
          TEACHER_CHOICE = 2,
          ROOM_CHOICE = 3,
          COURSE_CHOICE = 4;
  private String firstName, lastName, courseName, teacherTitle,
          city, streetAddress, roomName, teacherId = "";
  private int roomNumber;
  private List<String> selectedCourses = new ArrayList<>();

  private List<?> list;

  /**
   * Creates a new instance of Controller
   */
  public Controller() {
  }

  public List<Room> getRooms() {
    return cm.findRooms("");
  }

  public String addRoom() {
    Room tempRoom = new Room();
    tempRoom.setNumber(roomNumber);
    tempRoom.setName(roomName);

    cm.addRoom(tempRoom);
    
    emptyUi();
    
    return "index";
  }

  public String addStudent() {
    Student tempStd = new Student();
    tempStd.setFirstName(firstName);
    tempStd.setLastName(lastName);

    Address tempAddr = new Address();
    tempAddr.setStreetAddress(streetAddress);
    tempAddr.setCity(city);

    tempStd.setAddress(tempAddr);
    if (this.selectedCourses.size() > 0) {
      Course tempCourse;
      List<Course> tempList;
      List<Course> addList = new ArrayList<>();
      for (String s : this.selectedCourses) {
        tempList = cm.findCourses(s);
        if (tempList.size() > 0) {
          tempCourse = tempList.get(0);
          addList.add(tempCourse);
        }
      }
      tempStd.setCourseList(addList);
    }

    cm.addStudent(tempStd);
    
    emptyUi();
    
    return "index";
  }

  public List<Teacher> getTeachers() {
    return cm.findTeachers(0);
  }

  public String addTeacher() {
    Teacher tempTchr = new Teacher();
    tempTchr.setTitle(teacherTitle);
    tempTchr.setFirstName(firstName);
    tempTchr.setLastName(lastName);

    Address tempAddr = new Address();
    tempAddr.setStreetAddress(streetAddress);
    tempAddr.setCity(city);

    tempTchr.setAddress(tempAddr);

    cm.addTeacher(tempTchr);
    
    emptyUi();

    return "index";
  }

  public String addCourse() {
    Course tempCourse = new Course();
    int tempId = Integer.parseInt(this.getTeacherId());
    List<Teacher> tempTeacher = cm.findTeachers(tempId);
    tempCourse.setName(courseName);
    if (tempTeacher.size() > 0) {
      tempCourse.setTeacher(tempTeacher.get(0));
    }
    List<Room> tempRooms = cm.findRooms(roomName);
    if (tempRooms.size() > 0) {
      tempCourse.setRoom(tempRooms.get(0));
    }
    cm.addCourse(tempCourse);

    emptyUi();
    
    return "index";
  }

  public void remove(Object o) {
    if (o instanceof com.opiframe.java.coursemanager.models.Student) {
      cm.removeStudent((Student) o);
    }
    if (o instanceof com.opiframe.java.coursemanager.models.Teacher) {
      cm.removeTeacher((Teacher) o);
    }
    if (o instanceof com.opiframe.java.coursemanager.models.Room) {
      cm.removeRoom((Room) o);
    }
    if (o instanceof com.opiframe.java.coursemanager.models.Course) {
      cm.removeCourse((Course) o);
    }
  }

  /**
   * @return the list
   */
  public List<?> findList(int choice) {
    switch (choice) {
      case STUDENT_CHOICE:
        return cm.findStudents();
      case TEACHER_CHOICE:
        return cm.findTeachers(0);
      case ROOM_CHOICE:
        return cm.findRooms("");
      case COURSE_CHOICE:
        return cm.findCourses("");
      default:
        return null;
    }
  }

  public void emptyUi(){
    this.teacherTitle = "";
    this.firstName = "";
    this.lastName = "";
    this.streetAddress = "";
    this.city = "";
    this.roomName = "";
    this.roomNumber = 0;
    this.teacherId = "";
    this.courseName = "";
    this.selectedCourses = new ArrayList<>();
  }
   
  /**
   * @param list the list to set
   */
  public void setList(List<?> list) {
    this.list = list;
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
   * @return the courseName
   */
  public String getCourseName() {
    return courseName;
  }

  /**
   * @param courseName the courseName to set
   */
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  /**
   * @return the teacherTitle
   */
  public String getTeacherTitle() {
    return teacherTitle;
  }

  /**
   * @param teacherTitle the teacherTitle to set
   */
  public void setTeacherTitle(String teacherTitle) {
    this.teacherTitle = teacherTitle;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the streetAddress
   */
  public String getStreetAddress() {
    return streetAddress;
  }

  /**
   * @param streetAddress the streetAddress to set
   */
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  /**
   * @return the roomName
   */
  public String getRoomName() {
    return roomName;
  }

  /**
   * @param roomName the roomName to set
   */
  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  /**
   * @return the roomNumber
   */
  public int getRoomNumber() {
    return roomNumber;
  }

  /**
   * @param roomNumber the roomNumber to set
   */
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  /**
   * @return the teacherId
   */
  public String getTeacherId() {

    if (!this.teacherId.isEmpty()) {
      return this.teacherId.split(",")[0];
    }
    return "";
  }

  /**
   * @param teacherId the teacherId to set
   */
  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  /**
   * @return the selectedCourses
   */
  public List<String> getSelectedCourses() {
    return selectedCourses;
  }

  /**
   * @param selectedCourses the selectedCourses to set
   */
  public void setSelectedCourses(List<String> selectedCourses) {
    this.selectedCourses = selectedCourses;
  }
}
