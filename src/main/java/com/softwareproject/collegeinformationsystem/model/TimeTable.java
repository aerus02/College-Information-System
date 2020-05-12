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
@Table(name="timetables")
public class TimeTable {
    @Id
    private int timetableID;
    private int courseID;
    @Column(columnDefinition = "integer default -1")
    private int timings1;
    @Column(columnDefinition = "integer default -1")
    private int timings2;
    @Column(columnDefinition = "integer default -1")
    private int timings3;
    @Column(columnDefinition = "integer default -1")
    private int timings4;
    private String venue1;
    private String venue2;
    private String venue3;
    private String venue4;

    public String getVenue1() {
        return venue1;
    }

    public void setVenue1(String venue1) {
        this.venue1 = venue1;
    }

    public String getVenue2() {
        return venue2;
    }

    public void setVenue2(String venue2) {
        this.venue2 = venue2;
    }

    public String getVenue3() {
        return venue3;
    }

    public void setVenue3(String venue3) {
        this.venue3 = venue3;
    }

    public String getVenue4() {
        return venue4;
    }

    public void setVenue4(String venue4) {
        this.venue4 = venue4;
    }
    
    
    
    public int getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(int timeTableID) {
        this.timetableID = timeTableID;
    }
    

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getTimings1() {
        return timings1;
    }

    public void setTimings1(int timings1) {
        this.timings1 = timings1;
    }

    public int getTimings2() {
        return timings2;
    }

    public void setTimings2(int timings2) {
        this.timings2 = timings2;
    }

    public int getTimings3() {
        return timings3;
    }

    public void setTimings3(int timings3) {
        this.timings3 = timings3;
    }

    public int getTimings4() {
        return timings4;
    }

    public void setTimings4(int timings4) {
        this.timings4 = timings4;
    }

    

    public TimeTable() {
        this.courseID = 0;
        this.timings1 = -1;
        this.timings2 = -1;
        this.timings3 = -1;
        this.timings4 = -1;
        this.venue1 = null;
        this.venue2 = null;
        this.venue3 = null;
        this.venue4 = null;
    }
    
    
    
}
