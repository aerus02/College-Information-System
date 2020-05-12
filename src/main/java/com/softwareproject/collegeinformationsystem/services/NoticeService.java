/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.NoticeRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.Notice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class NoticeService {
    
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }
    
    public List<Notice> FindAllService(){
        List<Notice> notices = new ArrayList<>();
        Iterable<Notice> iterableNotices = noticeRepository.findAll();
        for(Notice t:iterableNotices)
               notices.add(t);
        return notices; 
    }
    
    public List<Notice> FindByCourseIDService(int courseID){
         List<Notice> notices;
        if(courseID == 0){
            notices = FindAllService();
            return notices;
        }
        notices = noticeRepository.findByCourseID(courseID);
        if(courseID == -1 || notices == null || notices.isEmpty()) return null;
        return notices;
    }
    
 
    public List<Notice> FindNoticesByCourseIDsService(List<Integer> courseIDs){
        List<Notice> noticesList= new ArrayList<>();
        List<Notice>temporaryList;
        int j;
        for(int i = 0; i < courseIDs.size();i +=1){
            temporaryList = FindByCourseIDService(courseIDs.get(i));
            if(temporaryList == null) continue;
            for(j = 0; j < temporaryList.size(); j += 1){
                if(!noticesList.contains(temporaryList.get(j))) 
                    noticesList.add(temporaryList.get(j));
            }
        }
        return noticesList;
    }
    
    public void DeleteByIDService(int noticeID){
        noticeRepository.deleteById(noticeID);
    }
         
    public boolean ExistByIDService(int noticeID){
        return noticeRepository.existsById(noticeID);
    }
    
    public long FindCountService(){
        return noticeRepository.count();
    }//set courseIDs in controller itself
    
    public void SaveEntityService(Notice notice ){
        //notice should not be null,it may not contain id
        long size = FindCountService();
        boolean check;
        int i;
        for(i = 1;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        notice.setNoticeID(i);
        noticeRepository.save(notice);
    }
    
    
}
