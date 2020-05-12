/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.services;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import java.util.List;


/**
 *
 * @author aerus02
 */

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    
    public void SaveUser(User user){
        userRepository.save(user);
    }
    
    public List<User> SearchUserByUsernameService(User user){
         List<User> list = userRepository.findByUsername(user.getUsername());
         return list;
    }
    
    public User FindByUsernameService(String username){
        List<User> userList = userRepository.findByUsername(username);
        if(userList == null || userList.size() == 0) return null;
        return userList.get(0);
    }
    
    ///to delete user,
    //add - update id in student/faculty

         
    public boolean ExistByIDService(int userID){
        return userRepository.existsById(userID);
    }
    
    public long FindCountService(){
        return userRepository.count();
    }
    
        
    /*public void DeleteByIDService(int userID){
        userRepository.deleteById(userID);
        update simultaneous tables
    }*/
    
    public int SaveEntityService(User user ){
        long size = FindCountService();//verify uique username or not
        boolean check;
        int i;
        for(i = 2;i < size+2; i+=1){
            check = ExistByIDService(i);
            if(!check) break;
        }
        user.setUserID(i);
        userRepository.save(user);
        return user.getUserID();
        
    }
    //use this id to add in student/fac table
    
    public void ChangePasswordService(String username,String password ){
        User user = FindByUsernameService(username);
        userRepository.deleteById(user.getUserID());
        user.setPassword(password);
        userRepository.save(user);
    }
    
    
}
