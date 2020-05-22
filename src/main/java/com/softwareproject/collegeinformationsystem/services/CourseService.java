/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class CourseService {
    
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public Course FindByCourseIDService(int courseID){
        Course course = courseRepository.findById(courseID).orElse(null);
        return course;
    }
    
    public List<Course> FindByCourseIDListService(List<Integer> courseIDs){
        List<Course> coursesList = new ArrayList<>();
        for(int i = 0;i < courseIDs.size();i += 1){
            coursesList.add(FindByCourseIDService(courseIDs.get(i)));
        }
        return coursesList;
    }
    
    public List<Course> FindByFacultyIDService(int facultyID){
        List<Course> coursesList = courseRepository.findByFacultyID(facultyID);
        return coursesList;
    }
    
    public List<Course> FindAllService(){
        List<Course> coursesList = new ArrayList<>();
        Iterable<Course> iterableCourses = courseRepository.findAll();
  
        for (Course t : iterableCourses) 
            coursesList.add(t); 
        
        return coursesList;
    }
    
    public List<Integer> FindFacultyIDsByCourseIDsService(List<Integer> courseIDs){
        List<Integer> facultyIDs = new ArrayList<>();
        Course course;
        int facultyId;
        for(int i = 0; i < courseIDs.size(); i +=1){
            course = courseRepository.findById(courseIDs.get(i)).orElse(null);
            if(course == null) continue;
            facultyId = course.getFacultyID();
            if(!facultyIDs.contains(facultyId)) facultyIDs.add(facultyId);
        }
        return facultyIDs;
    }
    
    public List<Integer> FindCourseIDsByFacultyIDService(int facultyID){
        List<Course> coursesList =  FindByFacultyIDService(facultyID);
        List<Integer> courseIDs = new ArrayList<>();
        
        for(int i =0; i < coursesList.size(); i+= 1){
            courseIDs.add(coursesList.get(i).getCourseID());        
        }
        return courseIDs;
    }
    
    public Course FindByCollegeIDService(String collegeID){
       List<Course>courses = FindAllService();
       int i;
       for( i = 0; i < courses.size(); ++i){
           if(courses.get(i).getCollegeID().equals(collegeID)) break;
       }
       if( i < courses.size())return courses.get(i);
       else return null;
    }
    
}
