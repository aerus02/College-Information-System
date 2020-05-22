/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.Notice;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.NoticeRepository;
import com.softwareproject.collegeinformationsystem.services.UserService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.NoticeService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;

/**
 *
 * @author aerus02
 */

@Controller
public class NoticeCreateController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    NoticeRepository noticeRepository;
    
    
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
     
    
    @RequestMapping("/notices-create")
    public ModelAndView NoticesCreateFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("NoticesCreateFunction is called in controller");
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
        String username = (String)session.getAttribute("username");
        System.out.println((String)session.getAttribute("username") + (String)session.getAttribute("password"));
        
        
        UserService userService = new UserService(userRepository);
        CourseService courseService = new CourseService(courseRepository);
        NoticeService noticeService = new NoticeService(noticeRepository);
        
        System.out.println("NoticesCreateFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        int pageType = 1;
        pageType = Integer.parseInt(req.getParameter("type"));
        if(pageType != 2){
            if(userType == 1){
                mv = new ModelAndView("noticescreatepage");
                return mv;

            }
            else{
               try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return new ModelAndView("index");
                }
                mv = new ModelAndView("index");

                return mv;
            }
        }
        else{
            if(userType == 1){
                mv = new ModelAndView("noticescreatepage");
                String courseID = req.getParameter("courseID");
                String Title = req.getParameter("title");
                String shortDescription = req.getParameter("minidesc");
                String completeDescription = req.getParameter("compdesc");
                long d = System.currentTimeMillis();
		Date date = new Date(d);
                if(courseID == null || Title == null || shortDescription == null || completeDescription== null){
                    return new ModelAndView("noticescreatepage");
                }
                Course course = courseService.FindByCollegeIDService(courseID);
               
                if(course == null) return new ModelAndView("noticescreatepage");
                Notice notice = new Notice();
                notice.setCompleteDescription(completeDescription);
                notice.setCourseID(course.getCourseID());
                notice.setDescription(shortDescription);
                notice.setDateCreated(date);
                notice.setHeading(Title);
                noticeService.SaveEntityService(notice);
                
                
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return new ModelAndView("index");
                }
                return mv;

            }
            else{
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return new ModelAndView("index");
                }
                mv = new ModelAndView("index");

                return mv;
            }
            
        }
    }
    
    @RequestMapping("/notices-delete")
    public ModelAndView NoticesDeleteFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("NoticesDeleteFunction is called in controller");
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
        String username = (String)session.getAttribute("username");
        System.out.println((String)session.getAttribute("username") + (String)session.getAttribute("password"));
        
        
        NoticeService noticeService = new NoticeService(noticeRepository);
        
        System.out.println("NoticesDeleteFunction ,before logic begins");
        int noticeID = Integer.parseInt(req.getParameter("noticeID"));
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        if(userType == 1){
            noticeService.DeleteByIDService(noticeID);
        }
        
        try{
             res.sendRedirect("/home");
         }
         catch(Exception e){
             System.out.println(e +" -error");
             return new ModelAndView("index");
         }
         mv = new ModelAndView("index");

         return mv;
        
    }
        
    
    
}
