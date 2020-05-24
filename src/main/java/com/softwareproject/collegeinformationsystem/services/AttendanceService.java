/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Attendance;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class AttendanceService {
    
    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }
    
    public List<Integer> FindStudentIDsByCourseIDService(int courseID){
        List<Attendance> attendanceList = attendanceRepository.findByCourseID(courseID);
        if(attendanceList == null) return null;
        if(attendanceList.isEmpty()) return null;
        
        List<Integer> studentsList = new ArrayList<>();
         for(int i = 0;i < attendanceList.size();i +=1){
            studentsList.add(attendanceList.get(i).getStudentID());    
        }
        return studentsList;
    }
    
    public List<Integer> FindCourseIDsByStudentIDService(int studentID){
        List<Attendance> attendanceList = attendanceRepository.findByStudentID(studentID);
        if(attendanceList == null || attendanceList.isEmpty()) return null;
        List<Integer> coursesList = new ArrayList<>();
         for(int i = 0;i < attendanceList.size();i +=1){
            coursesList.add(attendanceList.get(i).getCourseID());    
        }
        return coursesList;
    }
    
    public List<Integer> FindStudentIDsByCourseIDsService(List <Integer> CourseIDs){
        List<Integer>StudentIDs = new ArrayList<>();
        int j;
        List<Integer> temporaryStudentIDs;
        for(int i = 0; i < CourseIDs.size(); i += 1){
            temporaryStudentIDs = FindStudentIDsByCourseIDService(CourseIDs.get(i));
            if(temporaryStudentIDs == null) continue;
            for(j = 0;j < temporaryStudentIDs.size();j += 1){
                if(!StudentIDs.contains(temporaryStudentIDs.get(j)))
                    StudentIDs.add(temporaryStudentIDs.get(j));
            }
        }
        return StudentIDs;
    }    
    
    public ArrayList<ArrayList<Integer>> FindStudentAttendanceByStudentIDService(int studentID){
        List<Attendance> attendanceList = attendanceRepository.findByStudentID(studentID);
        if(attendanceList == null || attendanceList.isEmpty()) return null;
        ArrayList<Integer> temporaryList;
        Attendance attendance;
        var listAttendance = new  ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < attendanceList.size();i += 1){
            temporaryList = new ArrayList<>();
            attendance = attendanceList.get(i);
            temporaryList.add(0,attendance.getValue1());
            temporaryList.add(1,attendance.getValue2());
            temporaryList.add(2,attendance.getValue3());
            temporaryList.add(3,attendance.getValue4());
            temporaryList.add(4,attendance.getCourseID());
            listAttendance.add(i,temporaryList);
        }
        return listAttendance;
    
    }
    
    public ArrayList<ArrayList<Integer>> FindFacultyAttendanceByCourseIDService(int courseID){
        List<Attendance> attendanceList = attendanceRepository.findByCourseID(courseID);
        if(attendanceList == null || attendanceList.isEmpty()) return null;
        ArrayList<Integer> temporaryList;
        Attendance attendance;
        var listAttendance = new  ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < attendanceList.size();i += 1){
            temporaryList = new ArrayList<>();
            attendance = attendanceList.get(i);
            temporaryList.add(0,attendance.getValue1());
            temporaryList.add(1,attendance.getValue2());
            temporaryList.add(2,attendance.getValue3());
            temporaryList.add(3,attendance.getValue4());
            temporaryList.add(4,attendance.getStudentID());
            listAttendance.add(i,temporaryList);
        }
        return listAttendance;
    }
    
    public int FindIDByCourseIDAndStudentIDService(Attendance attendance){
        List<Attendance> attendanceList = attendanceRepository.findByCourseID(attendance.getCourseID());
        int i;
        for(i = 0; i < attendanceList.size(); i+=1){
           if(attendanceList.get(i).getStudentID() == attendance.getStudentID())  break;
        }
        if(i < attendanceList.size()) return attendanceList.get(i).getAttendanceID();
        else return 0;
    }
    
    public void DeleteEntityService(int attendanceID){
        attendanceRepository.deleteById(attendanceID);
    }
    
    public void SaveEntityService(Attendance attendance){
        attendanceRepository.save(attendance);
    }
    
    public void UpdateEntityService(Attendance attendance){
        int attendanceID = FindIDByCourseIDAndStudentIDService(attendance);
        if(attendanceID == 0) return;
        attendance.setAttendanceID(attendanceID);
        DeleteEntityService(attendanceID);
        SaveEntityService(attendance);
    }
    
    public boolean ExistByIDService(int attendanceID){
        return attendanceRepository.existsById(attendanceID);
    }
    
    public long FindCountService(){
        return attendanceRepository.count();
    }
    
    public void SaveEntityWithoutIDService(Attendance attendance){
         long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        attendance.setAttendanceID(i);
        attendanceRepository.save(attendance);
    }
}
