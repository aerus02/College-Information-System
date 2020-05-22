/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aerus02
 */
@Entity
@Table(name="pollings")
public class Polling {
    @Id
    private int pollID;
    private String heading;
    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
     @Column(columnDefinition = "integer default 0")
    private int count1;
      @Column(columnDefinition = "integer default 0")
    private int count2;
       @Column(columnDefinition = "integer default 0")
    private int count3;
        @Column(columnDefinition = "integer default 0")
    private int count4;
    private Date dateCreated;//dates not considered
    private Date dateExpired;
    
    @Column(columnDefinition = "Integer default -1")
    private int courseID;

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }

    public int getCount4() {
        return count4;
    }

    public void setCount4(int count4) {
        this.count4 = count4;
    }
    

    public int getPollID() {
        return pollID;
    }

    public void setPollID(int pollID) {
        this.pollID = pollID;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Polling() {
        this.heading = null;
        this.description = null;
        this.option1 = null;
        this.option2 = null;
        this.option3 = null;
        this.option4 = null;
        this.dateCreated = null;
        this.dateExpired = null;
        this.courseID = -1;
        this.count1 = 0;
        this.count2 = 0;
        this.count3 = 0;
        this.count4 = 0;
    }

    @Override
    public String toString() {
        return "Polling{" + "heading=" + heading + ", description=" + description + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", count1=" + count1 + ", count2=" + count2 + ", count3=" + count3 + ", count4=" + count4 + ", dateCreated=" + dateCreated + ", dateExpired=" + dateExpired + ", courseID=" + courseID + '}';
    }
    
    public String dataToDescription(){
        String str = "Results : \n"+this.option1+" : "+this.count1+"\n"+this.option2 +" : "+this.count2+"\n"+this.option3+" : "+this.count3+"\n"+this.option4+" : "+this.count4+"\n";
        return str;
    }
    
    public String dataToMiniDescription(){
        String str = "Polling Description - "+this.description;
        return str;
    }
    
    
}
