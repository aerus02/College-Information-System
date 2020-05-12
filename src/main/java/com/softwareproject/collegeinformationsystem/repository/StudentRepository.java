/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.repository;

import com.softwareproject.collegeinformationsystem.model.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aerus02
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{
    List<Student> findByUserID(int userID);
    List<Student> findByCollegeID(String collegeID);//check if possible
}
