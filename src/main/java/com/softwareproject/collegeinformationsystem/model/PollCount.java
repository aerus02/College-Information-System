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
@Table(name="pollcount")
public class PollCount {
    @Id
    private int pollcountID;
    private int pollID;
    private int courseID;
    private int studentID;
    @Column(columnDefinition = "integer default 0")
    private int option1;//selected by user1,2,3,4

    public PollCount() {
        this.pollcountID = 0;
        this.courseID= 0;
        this.studentID = 0;
        this.option1 = 0;
        this.pollID = 0;
    }

    @Override
    public String toString() {
        return "PollCount{" + "pollcountID=" + pollcountID + ", pollID=" + pollID+ ", courseID=" + courseID + ", studentID=" + studentID + ", option=" + option1 + '}';
    }
    
    public int getPollcountID() {
        return pollcountID;
    }

    public void setPollcountID(int pollcountID) {
        this.pollcountID = pollcountID;
    }

    public int getPollID() {
        return pollID;
    }

    public void setPollID(int pollID) {
        this.pollID = pollID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getOption() {
        return option1;
    }

    public void setOption(int option) {
        this.option1 = option;
    }
    
}
