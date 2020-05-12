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
@Table(name="notices")
public class Notice {
    @Id
    private int noticeID;
    private String description;
    private String heading;
    private String completeDescription;
    private Date dateCreated; //dates not considered,check later
    private Date dateExpired;
    
     @Column(columnDefinition = "integer default -1")
    private int courseID;

    public int getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(int noticeID) {
        this.noticeID = noticeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getCompleteDescription() {
        return completeDescription;
    }

    public void setCompleteDescription(String completeDescription) {
        this.completeDescription = completeDescription;
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

    public Notice() {
        this.description = null;
        this.heading = null;
        this.completeDescription = null;
        this.dateCreated = null;
        this.dateExpired = null;
        this.courseID = -1;
    }


    @Override
    public String toString() {
        return "Notice{" + "description=" + description + ", heading=" + heading + ", completeDescription=" + completeDescription + ", dateCreated=" + dateCreated + ", dateExpired=" + dateExpired + ", courseID=" + courseID + '}';
    }
   
}
