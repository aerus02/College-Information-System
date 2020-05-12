/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.softwareproject.collegeinformationsystem.model.Course;
import java.util.List;

/**
 *
 * @author aerus02
 */
public interface CourseRepository extends CrudRepository<Course,Integer> {
    
    List<Course>findByFacultyID(int facultyID);
   
    
}
