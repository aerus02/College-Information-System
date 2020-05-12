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
@Table(name="admins")
public class Admin{
    
//    private String mailID;
    @Id
    private int adminID;
    private int userID;
//    private String Collegeid;
//    private int name;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    
    public Admin(int adminID) {
        this.adminID = adminID;
    }
    
    public Admin() {
        
    }

    /*public String getMailID() {
        return mailID;
    }

    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    public String getCollegeid() {
        return Collegeid;
    }

    public void setCollegeid(String Collegeid) {
        this.Collegeid = Collegeid;
    }

    public Admin(int adminID,String mailID, String Collegeid) {
        super();
        this.adminID = adminID;
        this.mailID = mailID;
        this.Collegeid = Collegeid;
    }
    
     public Admin(){
         super();
         this.adminID = 0;
         this.mailID = null;
         this.Collegeid = null;
         
     }
    

    @Override
    public String toString() {
        return "Admin{" +"userID=" +  super.getUserID() + ", username=" + super.getUsername() + ", password=" + super.getPassword()+ "mailID=" + mailID + ", Collegeid=" + Collegeid + '}';
    }
    */

    
    
    
}
