/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.OtherLink;
import com.softwareproject.collegeinformationsystem.repository.OtherLinkRepository;
import com.softwareproject.collegeinformationsystem.services.OtherLinkService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aerus02
 */
public class OtherLinksController {
    
    @Autowired
    OtherLinkRepository otherLinkRepository;
    
    public boolean checkLogin(HttpServletRequest req){
        
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        if(username == null || password == null ) return false;
        int userType;
        if(session.getAttribute("userType") != null)
        userType = (Integer)session.getAttribute("userType");
        else userType = 0;
        System.out.println("checkLogin is called");
        if(!username.equals("") && !password.equals("") && userType > 0) return true;
        return false;
    }
    
    @RequestMapping("/otherlinks")
    public ModelAndView OtherLinksFunction(HttpServletRequest req,HttpServletResponse res){ 
        
         System.out.println("OtherLinksFunction is called in controller");
        boolean check = checkLogin(req);
        if(!check){
            try{
                res.sendRedirect("/login");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("index");
            }
        }
        
        HttpSession session = req.getSession();
       
        ModelAndView mv;
        OtherLinkService otherLinkService = new OtherLinkService(otherLinkRepository);
        int userType = (int)session.getAttribute("userType");
        
        if(userType == 2){
            try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("homepagefaculty");
            }
        }
        
        List<OtherLink> otherLinks = otherLinkService.FindAllService();
        mv = new ModelAndView("otherlinksviewpage");
        mv.addObject(otherLinks);
        return mv;
    
    }
}
