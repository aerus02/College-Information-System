/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public boolean ExistByUserIDService(int userID){
        List<Student> list = studentRepository.findByUserID(userID);
        if(list == null) return false;
        if(list.isEmpty()) return false;
        return true;
    }
    
    public Student FindByIDService(int studentID){
        Student student = studentRepository.findById(studentID).orElse(null);
        return student;
    }
    
    public List<Student> FindByIDListService(List<Integer> studentIDs){
        List<Student>names = new ArrayList<>();
        for(int i = 0;i < studentIDs.size();i += 1){
            names.add(FindByIDService(studentIDs.get(i)));//object can be null,check?
        }
        return names;
    }
    
    public Student FindByUserIDService(int userID){
        List<Student> student = studentRepository.findByUserID(userID);
        if(student == null) return null;
        if(student.isEmpty()) return null;
        return student.get(0);
    }
    
    public List<Student> FindAllService(){
        List<Student> studentsList = new ArrayList<>();
        Iterable<Student> iterableStudents = studentRepository.findAll();
  
        for (Student t : iterableStudents) 
            studentsList.add(t); 
    
        return studentsList;
    }
    
    public Student FindByCollegeIDService(String collegeID){
        List<Student>studentsList = studentRepository.findByCollegeID(collegeID);
        if(studentsList == null || studentsList.isEmpty()) return null;
        return studentsList.get(0);
    }
    
    public boolean ExistByIDService(int studentID){
        return studentRepository.existsById(studentID);
    }
    
    public long FindCountService(){
        return studentRepository.count();
    }
    
    public int SaveEntityService(Student student ){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        student.setStudentID(i);
        studentRepository.save(student);
        return i;
    }
    
    public int FindNextService(){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        return i;
    }
    
    public void DeleteByIDService(int studentID){
        studentRepository.deleteById(studentID);
    }
    
}
