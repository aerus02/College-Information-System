/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.repository;

import com.softwareproject.collegeinformationsystem.model.Attendance;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aerus02
 */
public interface AttendanceRepository extends CrudRepository<Attendance,Integer>{
        List<Attendance> findByCourseID(int courseID);
        List<Attendance> findByStudentID(int studentID);
}
