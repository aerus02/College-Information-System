/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aerus02
 */
@Entity
@Table(name="courses")
public class Course {
    @Id
    private int courseID;
    //private int userID;
    private String coursename;
    private String collegeID; //like CS10028
    private int facultyID;//dept also to be taken from facID
    
    @Column(columnDefinition = "integer default 0")
    private int strength;
    //private String coursesession;//grades to be taken from attendance table
    private String roomnumber;

    public String getRoomNumber() {
        return roomnumber;
    }

    public void setRoomNumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }
    

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return coursename;
    }

    public void setCourseName(String courseName) {
        this.coursename = courseName;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public Course(String courseName, String collegeID) {
        this.coursename = courseName;
        this.courseID = 0;
        this.collegeID = collegeID;
        this.strength = 0;
        this.facultyID = 0;
        this.roomnumber = null;
    }
    //primary key to be set every instance
    public Course() {
        this.coursename = null;
        this.collegeID = null;
        this.courseID = 0;
        this.strength = 0;
        this.facultyID = 0;
        this.roomnumber = null;
    }

    @Override
    public String toString() {
        return "Course{" + "courseName=" + coursename + ", collegeID=" + collegeID + ", strength=" + strength  + '}';
    }
    
    
    
}
