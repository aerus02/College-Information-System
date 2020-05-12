/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.repository;


import com.softwareproject.collegeinformationsystem.model.Polling;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aerus02
 */
public interface PollingRepository extends CrudRepository<Polling,Integer>{
    
    public List<Polling> findByCourseID(int courseID);
    
    
}
