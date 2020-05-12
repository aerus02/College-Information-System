/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import com.softwareproject.collegeinformationsystem.model.Admin;
import com.softwareproject.collegeinformationsystem.repository.AdminRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aerus02
 */

@Service
@Transactional
public class AdminService {
    
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    public boolean ExistByUserIDService(int userID){
        System.out.println("Exist....in admin called,before its interface"+userID+adminRepository);
         List<Admin> list = adminRepository.findByUserID(userID);
         System.out.println("Exist....in admin called,after its interface"+list);
         if(list == null) return false;
         if(list.isEmpty()) return false;
         return true;
    }
    
    
    
}
