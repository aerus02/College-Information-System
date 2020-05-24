/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.TimeTableRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.TimeTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class TimeTableService {
    
    private final TimeTableRepository timeTableRepository;

    public TimeTableService(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }
    
    //get time table in 2d array for fac,student ,1d-course
    
    //take list of courseids n ,return list of list of courseids -fac,stu
    //print only coursename,id in o/p in table
    
    //for course,return simple list,display list with ame of course at top
    
    public TimeTable FindByIdService(int timeTableID){
        return timeTableRepository.findById(timeTableID).orElse(null);
    }
    
    public TimeTable FindByCourseIDService(int courseID){
       List<TimeTable> timeTable = timeTableRepository.findByCourseID(courseID);
       if(timeTable == null) return null;
       if(timeTable.isEmpty()) return null;
       return timeTable.get(0);
    }
    
    public ArrayList<ArrayList<Integer>> FindTimeTableByCourseIDsService(List<Integer> courseIDs){
        TimeTable temporaryTable;
        int j;
        int [][] arr = new int[5][9];
        for(int i = 0;i < 5; i+= 1)
            for( j = 0;j < 9; j+= 1)
                arr[i][j] = -1;
        
        for(int i = 0; i < courseIDs.size(); i += 1){
            temporaryTable =   FindByCourseIDService(courseIDs.get(i));
            if(temporaryTable == null) continue;
            j = temporaryTable.getTimings1();
            if(j != -1){//arr - check again arr[(j-1)/5][j%9],from 1 to 45
                arr[(j-1)/5][(j-1)%9] = i;//temporaryTable.getCourseID();
            }
            j = temporaryTable.getTimings2();
            if(j != -1){
                arr[(j-1)/5][(j-1)%9] = i;//temporaryTable.getCourseID();
            }
             j = temporaryTable.getTimings3();
            if(j != -1){
                arr[(j-1)/5][(j-1)%9] = i;//temporaryTable.getCourseID();
            }
             j = temporaryTable.getTimings4();
            if(j != -1){
                arr[(j-1)/5][(j-1)%9] = i;//temporaryTable.getCourseID();
            }
        }
        ArrayList<ArrayList<Integer>> timeTableList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0;i < 5; ++i){
            for(j = 0; j < 9; ++j) temp.add(j,arr[i][j]);
            timeTableList.add(i,temp);
            temp = new ArrayList<>();
            
        }        
        
        return timeTableList;       
    }
    
    public void DeleteByIDService(int timeTableID){
        timeTableRepository.deleteById(timeTableID);
    }
    
     public boolean ExistByIDService(int timeTableID){
        return timeTableRepository.existsById(timeTableID);
    }
    
    public long FindCountService(){
        return timeTableRepository.count();
    }
    
    public void SaveEntityService(TimeTable timeTable){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        timeTable.setTimetableID(i);
        timeTableRepository.save(timeTable);
    }
    
    
}
