/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.PollCountRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.PollCount;
import java.util.ArrayList;


/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class PollCountService {
    
    private final PollCountRepository pollCountRepository;
    
    public PollCountService(PollCountRepository pollCountRepository){
        this.pollCountRepository = pollCountRepository;
    }
    
    public List<Integer> FindPollIDListByStudentIDService(int studentID){
        List<PollCount> pollCounts = pollCountRepository.findByStudentID(studentID);
        
        List<Integer> pollIDs = new ArrayList<>();//returning list ,not arr
        int i;
        for(i = 0;i < pollCounts.size(); i+=1){
            if(pollCounts.get(i).getOption()==0)
            pollIDs.add(i,pollCounts.get(i).getPollID());
        }
        return pollIDs;
    }
     public List<PollCount> FindAllService(){
        List<PollCount> pollCounts = new ArrayList<>();
        
        Iterable<PollCount> iterableLinks = pollCountRepository.findAll();
        for (PollCount t : iterableLinks) 
            pollCounts.add(t); 
        return pollCounts;
    }
    
    public List<PollCount> FindByPollIDService(int pollID){
        //return pollCountRepository.findByPollID(pollID);
        List<PollCount>pollCountList = FindAllService();
//        System.out.println("pollcountservice-findall");
//        System.out.println(pollCountList);
        List<PollCount>reqList = new ArrayList<>();
        for(int i = 0; i < pollCountList.size(); i +=1){
            if(pollCountList.get(i).getPollID() == pollID) reqList.add(pollCountList.get(i));
        }
//        System.out.println(reqList);
        return reqList;
    }
    
    public List<Integer> FindCountsByPollService(int pollID){
        List<Integer> pollCounts = new  ArrayList<>();
        int []counts = new int [4];
        counts[0] = counts[1] = counts[2] = counts[3] = 0;
        List<PollCount>pollCountList = FindByPollIDService(pollID);
        for(int i = 0; i < pollCountList.size(); i += 1){
           if(pollCountList.get(i).getOption() == 1) ++counts[0];
           else if(pollCountList.get(i).getOption() == 2) ++counts[1];
           else if(pollCountList.get(i).getOption() == 3) ++counts[2];
           else if(pollCountList.get(i).getOption() == 4) ++counts[3];
     
        }
        for(int i = 0; i < 4; i += 1)
            pollCounts.add(i,counts[i]);
        return pollCounts;
    }
    
    public List<List<Integer> >FindCountsByPollListService(List<Integer>pollIDs){
        List<List<Integer> >pollListCounts  = new ArrayList<>();
        for(int i = 0; i < pollIDs.size(); i += 1)
            pollListCounts.add(i,FindCountsByPollService(pollIDs.get(i)));
        return pollListCounts;
    }
    
    public boolean ExistByIDService(int pollCountID){
        return pollCountRepository.existsById(pollCountID);
    }
    
    public long FindCountService(){
        return pollCountRepository.count();
    }
    
    public int SaveEntityService(PollCount pollCount ){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        pollCount.setPollcountID(i);
        pollCountRepository.save(pollCount);
        return i;
    }
    
    public void SaveEntityListService(int pollID,int courseID,List<Integer>studentIDs){
        PollCount pollCount;
        for(int i = 0; i < studentIDs.size();i +=1){
            pollCount = new PollCount();
            pollCount.setCourseID(courseID);
            pollCount.setStudentID(studentIDs.get(i));
            pollCount.setPollID(pollID);
            SaveEntityService(pollCount);
        }
    }
    
    public void DeleteEntityService(int pollCountID){
        pollCountRepository.deleteById(pollCountID);
    }
    
    public void DeleteEntityByPollIDService(int pollID){
//        List<PollCount>pollCounts = pollCountRepository.findByPollID(pollID);
        List<PollCount>pollCounts = FindByPollIDService(pollID);
        for(int i = 0; i < pollCounts.size(); i +=1){
            DeleteEntityService(pollCounts.get(i).getPollcountID());
        }
    }
    
    public void SaveEntityWithIDService(PollCount pollCount){
        pollCountRepository.save(pollCount);
    }
    
    public void UpdateEntityByPollIDAndStudentID(int pollID,int studentID,int option){
         List<PollCount> pollCounts = FindByPollIDService(pollID);
//         System.out.println("In pollcountserv - upda..func");
//         System.out.println(pollCounts);
         int i;
         for(i = 0; i < pollCounts.size(); i+=1){
             if(pollCounts.get(i).getStudentID() == studentID) break;
         }
//         System.out.println(i +" "+studentID);
         if(i < pollCounts.size()){
             PollCount pollCount = pollCounts.get(i);
             pollCount.setOption(option);
             DeleteEntityService(pollCount.getPollcountID());
             SaveEntityWithIDService(pollCount);
         }
         
    }
}
