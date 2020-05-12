/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.repository.OtherLinkRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.OtherLink;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerus02
 */
@Service
@Transactional
public class OtherLinkService {
    
    private final OtherLinkRepository otherLinkRepository;

    public OtherLinkService(OtherLinkRepository otherLinkRepository) {
        this.otherLinkRepository = otherLinkRepository;
    }
    
    public List<OtherLink> FindAllService(){
        List<OtherLink> otherLinks = new ArrayList<>();
        
        Iterable<OtherLink> iterableLinks = otherLinkRepository.findAll();
  
        for (OtherLink t : iterableLinks) 
            otherLinks.add(t); 
        return otherLinks;
    }
    
}
