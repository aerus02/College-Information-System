/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aerus02
 */

@org.springframework.web.bind.annotation.RestController
public class RestReqController implements ErrorController{
    
    @RequestMapping("/error")
    public ModelAndView errorPageFunction(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("errorpage"); // mv.addObject("",)
        return mv;
    } 
    
    @Override
    public String getErrorPath(){
        return "/error";
    }
    
   /* @Autowired
    private UserRepository userRepository;
    
    UserService userService = new UserService(userRepository);
    
    @GetMapping("/updatemmmmmmm")
    public void somefunction(){
        System.out.println(" called");
    }
    
    @GetMapping("/saveusernnnnnnnn")
    public String saveUser(@RequestParam String username,@RequestParam String password){
        User user = new User(username,password);
        userService.SaveUser(user);
        
        return "user saved";
    }*/
}
