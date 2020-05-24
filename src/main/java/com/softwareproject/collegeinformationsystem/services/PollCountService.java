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
            pollIDs.add(i,pollCounts.get(i).getStudentID());
        }
        return pollIDs;
    }
    
    public List<PollCount> FindByPollIDService(int pollID){
        return pollCountRepository.findByPollID(pollID);
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
    
}
