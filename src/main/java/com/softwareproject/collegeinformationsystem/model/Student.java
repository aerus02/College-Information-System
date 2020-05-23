/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aerus02
 */
@Entity
@Table(name="students")
public class Student{
    
    @Id
    private int studentID;//id from db
    private int userID;//linked userid
    private String collegeID; //like 18cs10028
    private String studentname;
    private Date dob;   //processing from user...
    private String mailID;
    private String phoneNumber;
    //String[] coursesList;
    private String gender;
    private String department;
    private int yearOfEnrollment;
    //float grade; - stored in attendance table
    private String enrolledCourse; //btech/..    

    @Override
    public String toString() {
        return "Student{" + "name=" + studentname + ", dob=" + dob + ", mailID=" + mailID + ", phoneNumber=" + phoneNumber  + ", gender=" + gender + ", department=" + department + ", yearOfEnrollment=" + yearOfEnrollment + ", studentID=" + studentID + ", collegeID=" + collegeID + ", enrolledCourse=" + enrolledCourse + '}';
    }

    public Student(String name, Date dob, String mailID, String phoneNumber, String gender, String department, int yearOfEnrollment, String collegeID, String enrolledCourse) {
        this.studentname = name;
        this.dob = dob;
        this.mailID = mailID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.department = department;
        this.yearOfEnrollment = yearOfEnrollment;
        this.collegeID = collegeID;
        this.enrolledCourse = enrolledCourse;
        this.userID = 0;
    }
    
    public Student(){
        this.studentname = null;
        this.dob = null;
        this.mailID = null;
        this.phoneNumber = null;
        this.gender = null;
        this.department = null;
        this.yearOfEnrollment = 0;
        this.collegeID = null;
        this.enrolledCourse = null;
        this.userID = 0;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return studentname;
    }

    public void setName(String name) {
        this.studentname = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(String enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }
    
    
}
