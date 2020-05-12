/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aerus02
 */
@Entity
@Table(name="otherlinks")
public class OtherLink {
    @Id
    private int otherlinkID;
    private String description;
    private String url;

    public int getOtherLinkID() {
        return otherlinkID;
    }

    public void setOtherLinkID(int otherLinkID) {
        this.otherlinkID = otherLinkID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OtherLink(String description, String url) {
        this.description = description;
        this.url = url;
    }
    
    public OtherLink() {
        this.description = null;
        this.url = null;
    }

    @Override
    public String toString() {
        return "OtherLink{" + "description=" + description + ", url=" + url + '}';
    }
    
    
    
}
