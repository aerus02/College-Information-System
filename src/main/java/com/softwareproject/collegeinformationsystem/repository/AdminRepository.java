/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.softwareproject.collegeinformationsystem.model.Admin;
import java.util.List;

/**
 *
 * @author aerus02
 */
public interface AdminRepository extends CrudRepository<Admin,Integer>{
//    public boolean existByUserID(int userID);
     List<Admin> findByUserID(int userID);
    
}
