/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.PollingRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Polling;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class PollingService {
    
    private final PollingRepository pollingRepository;

    public PollingService(PollingRepository pollingRepository) {
        this.pollingRepository = pollingRepository;
    }
    
    public List<Polling>FindAllService(){
        List<Polling> pollingsList = new ArrayList<Polling>();
        Iterable<Polling> iterablePolling= pollingRepository.findAll();
        for(Polling t:iterablePolling)
            pollingsList.add(t);
        return pollingsList;
    }
    
    public List<Polling> FindByCourseIDService(int courseID){
        List<Polling> pollsList;
        if(courseID == 0){
            pollsList = FindAllService();
            return pollsList;
        }
        pollsList = pollingRepository.findByCourseID(courseID);
        if(courseID == -1 || pollsList == null || pollsList.isEmpty()) return null;
        return pollsList;
    }
    
    public List<Polling> FindPollingsByCourseIDsService(List<Integer> courseIDs){
         List<Polling> pollingsList= new ArrayList<>();
        List<Polling>temporaryList;
        int j;
        for(int i = 0; i < courseIDs.size();i +=1){
            temporaryList = FindByCourseIDService(courseIDs.get(i));
            if(temporaryList == null || temporaryList.isEmpty()) continue;
            for(j = 0; j < temporaryList.size(); j += 1){
                if(!pollingsList.contains(temporaryList.get(j))) 
                    pollingsList.add(temporaryList.get(j));
            }
        }
        return pollingsList;
    }
    
    public boolean ExistByIDService(int pollID){
        return pollingRepository.existsById(pollID);
    }
    
    public void DeleteByIDService(int pollID){
        if(ExistByIDService(pollID))
        pollingRepository.deleteById(pollID);
    }
         
    
    public long FindCountService(){
        return pollingRepository.count();
    }
    
    public int SaveEntityService(Polling poll ){
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        poll.setPollID(i);
        pollingRepository.save(poll);
        return i;
    }
    
    public Polling FindByIDService(int pollID){
        return pollingRepository.findById(pollID).orElse(null);
    }
    
    public List<Polling> FindByIDsListService(List<Integer>pollIDs){
        List<Polling> pollingsList= new ArrayList<>();
        for(int i = 0; i < pollIDs.size(); i +=1){
            pollingsList.add(i,FindByIDService(pollIDs.get(i)));
        }
        return pollingsList;
    }
}
