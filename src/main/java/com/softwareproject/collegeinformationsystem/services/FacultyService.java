/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Faculty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class FacultyService {
    
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    
    public boolean ExistByUserIDService(int userID){
        List<Faculty> facultyList = facultyRepository.findByUserID(userID);
        if(facultyList == null) return false;
        if(facultyList.isEmpty()) return false;
        return true;
    }
    
    public Faculty FindByUserIDService(int userID){
        List<Faculty> facultyList = facultyRepository.findByUserID(userID);
        if(facultyList == null ) return null;
        if(facultyList.isEmpty()) return null;
        return facultyList.get(0);
    }
    
    public Faculty FindByIDService(int facultyID){
        Faculty faculty = facultyRepository.findById(facultyID).orElse(null);
        return faculty;
    }
    
    public List<Faculty> FindByFacultyIDsService(List<Integer> facultyIds){
        List<Faculty> faculties = new ArrayList<>();
        Faculty faculty;
        for(int i = 0; i < facultyIds.size();i+=1){
            faculty = facultyRepository.findById(facultyIds.get(i)).orElse(null);
            if(faculty == null) continue;
            faculties.add(faculty);
        }
        return faculties;
    }
    
    public List<Faculty> FindAllService(){
        List<Faculty>facultiesList = new ArrayList<>();
        facultyRepository.findAll();
        Iterable<Faculty> iterableFaculties = facultyRepository.findAll();
  
        for (Faculty t : iterableFaculties) 
            facultiesList.add(t); 
        
        return facultiesList;
    }
    
    public Faculty FindByCollegeIDService(String collegeID){
        List<Faculty>facultiesList = facultyRepository.findByCollegeID(collegeID);
        if(facultiesList == null || facultiesList.isEmpty()) return null;
        return facultiesList.get(0);
    }
    
    public boolean ExistByIDService(int facultyID){
        return facultyRepository.existsById(facultyID);
    }
    
    public long FindCountService(){
        return facultyRepository.count();
    }
    
    public int SaveEntityService(Faculty faculty ){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        faculty.setFacultyID(i);
        facultyRepository.save(faculty);
        return i;
    }
}
