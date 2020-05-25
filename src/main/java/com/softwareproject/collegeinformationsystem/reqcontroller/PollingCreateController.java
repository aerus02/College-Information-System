/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Polling;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.Notice;
import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.NoticeRepository;
import com.softwareproject.collegeinformationsystem.repository.PollCountRepository;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.repository.PollingRepository;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.AttendanceService;
import com.softwareproject.collegeinformationsystem.services.PollCountService;
import com.softwareproject.collegeinformationsystem.services.NoticeService;
import com.softwareproject.collegeinformationsystem.services.PollingService;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aerus02
 */

@Controller
public class PollingCreateController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    NoticeRepository noticeRepository;
    
    @Autowired
    PollingRepository pollingRepository;
    
    @Autowired
    PollCountRepository pollCountRepository;
    
    @Autowired
    AttendanceRepository attendanceRepository;
    
    
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
     
    
    @RequestMapping("/polling-create")
    public ModelAndView PollingCreateFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("PollingCreateFunction is called in controller");
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
        System.out.println((String)session.getAttribute("username") + (String)session.getAttribute("password"));
        
        
        CourseService courseService = new CourseService(courseRepository);
        PollingService pollingService = new PollingService(pollingRepository);
        PollCountService pollCountService = new PollCountService(pollCountRepository);
       AttendanceService attendanceService = new AttendanceService(attendanceRepository);
        
        System.out.println("PollingCreateFunction ,before logic begins");
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        int pageType = 1;
        pageType = Integer.parseInt(req.getParameter("type"));
        if(pageType != 2){
            if(userType == 1){
                mv = new ModelAndView("pollingcreatepage");
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
                mv = new ModelAndView("pollingcreatepage");
                String courseID = req.getParameter("courseID");
                String Title = req.getParameter("title");
                String Description = req.getParameter("description");
                String Option1 = req.getParameter("option1");
                String Option2 = req.getParameter("option2");
                String Option3 = req.getParameter("option3");
                String Option4 = req.getParameter("option4");
                
                long d = System.currentTimeMillis();
		Date date = new Date(d);
                if(courseID == null || Title == null || Description == null || Option1== null || Option2== null || Option3 == null || Option4== null){
                    return new ModelAndView("pollingcreatepage");
                }
                Course course = courseService.FindByCollegeIDService(courseID);
               
                if(course == null) return new ModelAndView("pollingcreatepage");
                Polling polling = new Polling();
                polling.setDescription(Description);
                polling.setCourseID(course.getCourseID());
                polling.setDateCreated(date);
                polling.setHeading(Title);
                polling.setOption1(Option1);
                polling.setOption2(Option2);
                polling.setOption3(Option3);
                polling.setOption4(Option4);
                
                int pollID = pollingService.SaveEntityService(polling);
                List<Integer>studentIDs = attendanceService.FindStudentIDsByCourseIDService(course.getCourseID());
                pollCountService.SaveEntityListService(pollID,course.getCourseID(),studentIDs);
                
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
    
     @RequestMapping("/polling-delete")
    public ModelAndView PollingDeleteFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("PollingDeleteFunction is called in controller");
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
        PollingService pollingService = new PollingService(pollingRepository);
        PollCountService pollCountService = new PollCountService(pollCountRepository);

        System.out.println("PollingDeleteFunction ,before logic begins");
        int pollID = Integer.parseInt(req.getParameter("pollID"));
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        if(userType == 1){
            Polling polling = pollingService.FindByIDService(pollID);
            if(polling != null){
                Notice notice = new Notice();
                notice.setHeading("Poll Ended- "+polling.getHeading());
                List<Integer>pollCountValues = pollCountService.FindCountsByPollService(pollID);
                
                polling.setCount1(pollCountValues.get(0));
                polling.setCount2(pollCountValues.get(1));
                polling.setCount3(pollCountValues.get(2));
                polling.setCount4(pollCountValues.get(3));
                long d = System.currentTimeMillis();
		Date date = new Date(d);
                notice.setDateCreated(date);
                notice.setCompleteDescription(polling.dataToDescription());
                notice.setDescription(polling.dataToMiniDescription());
                notice.setCourseID(polling.getCourseID());
                
                noticeService.SaveEntityService(notice);
                pollingService.DeleteByIDService(pollID);
            pollCountService.DeleteEntityByPollIDService(pollID);
            }
            
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
    
     @RequestMapping("/polling-participate")
    public ModelAndView PollingParticipateFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("PollingParticipateFunction is called in controller");
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
        
        
        PollCountService pollCountService = new PollCountService(pollCountRepository);

        System.out.println("PollingParticipateFunction ,before logic begins");
        int pollID = Integer.parseInt(req.getParameter("pollID"));
         int studentID = Integer.parseInt(req.getParameter("studentID"));
         if(req.getParameter("option") == null){
             try{
             res.sendRedirect("/polling-view");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("homepagestudent");
            }
             
         }
          int option = Integer.parseInt(req.getParameter("option"));
//          System.out.println("PollingParticipateFunction ,"+pollID+""+studentID+" "+option);
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        if(userType == 3){
            
            pollCountService.UpdateEntityByPollIDAndStudentID(pollID,studentID,option);
            
        }
        
        try{
             res.sendRedirect("/home");
         }
         catch(Exception e){
             System.out.println(e +" -error");
//             return new ModelAndView("homepagestudent");
         }
         mv = new ModelAndView("homepagestudent");

         return mv;
        
    }
}
