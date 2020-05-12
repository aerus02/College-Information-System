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
@Table(name="faculties")
public class Faculty {
    @Id
    private int facultyID;
    private int userID;
    private String collegeID;
    private String name;
    private Date dob;
    private String mailID;
    private String phoneNumber;
    private String gender;
    private String department;
    private Date doj;//joining
    private Date dol;//leaving

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getDol() {
        return dol;
    }

    public void setDol(Date dol) {
        this.dol = dol;
    }

    public Faculty( String collegeID, String name, Date dob, String mailID, String phoneNumber, String gender, String department, Date doj, Date dol) {
        this.userID = 0;
        this.collegeID = collegeID;
        this.name = name;
        this.dob = dob;
        this.mailID = mailID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.department = department;
        this.doj = doj;
        this.dol = dol;
    }
    
    public Faculty() {
        this.userID = 0;
        this.collegeID = null;
        this.name = null;
        this.dob = null;
        this.mailID = null;
        this.phoneNumber = null;
        this.gender = null;
        this.department = null;
        this.doj = null;
        this.dol = null;
    }

    @Override
    public String toString() {
        return "Faculty{" + "collegeID=" + collegeID + ", name=" + name + ", dob=" + dob + ", mailID=" + mailID + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", department=" + department + ", doj=" + doj + ", dol=" + dol + '}';
    }
    
    
    
    
}
