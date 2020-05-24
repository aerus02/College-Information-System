/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.OtherLink;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.Attendance;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.OtherLinkRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.services.OtherLinkService;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.AttendanceService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
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
public class AdminAddDataOtherLinksController {
    
    @Autowired
     CourseRepository courseRepository;
    
    @Autowired
     StudentRepository studentRepository;
    
    @Autowired
    OtherLinkRepository otherLinkRepository;
    
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
    
    @RequestMapping("/add-data")
    public ModelAndView AdminAddDataFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataFunction is called in controller");
        boolean check = checkLogin(req);
        if(!check){
            try{
                res.sendRedirect("/login");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        HttpSession session = req.getSession();
        int userType = (int)session.getAttribute("userType");
        if(userType == 1)
            return new ModelAndView("adddatapageadmin");
            
        else{
             try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
             return new ModelAndView("index");
        }
    }
    
    @RequestMapping("/add-data-otherlinks")
    public void AdminAddDataOtherLinksFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataOtherLinksFunction is called in controller");
        boolean check = checkLogin(req);
        if(!check){
            try{
                res.sendRedirect("/login");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        HttpSession session = req.getSession();
        int userType = (int)session.getAttribute("userType");
        if(userType == 1){
            String url = req.getParameter("url");
            String desc = req.getParameter("desc");
            if(url == null ||  desc == null){
                try{
                res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            OtherLinkService otherLinkService = new OtherLinkService(otherLinkRepository);
            OtherLink oth = new OtherLink();
            oth.setUrl(url);
            oth.setDescription(desc);
            otherLinkService.SaveEntityService(oth);
                
            try{
                res.sendRedirect("/add-data");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        else{
            try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        
    }

    @RequestMapping("/add-data-attendance")
    public void AdminAddDataAttendanceFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataAttendanceFunction is called in controller");
        boolean check = checkLogin(req);
        if(!check){
            try{
                res.sendRedirect("/login");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        HttpSession session = req.getSession();
        int userType = (int)session.getAttribute("userType");
        if(userType == 1){
            String couCollegeID = req.getParameter("couCollegeID");
            if(couCollegeID == null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            CourseService courseService = new CourseService(courseRepository);
            StudentService studentService = new StudentService(studentRepository);
            AttendanceService attendanceService = new AttendanceService(attendanceRepository);
            int i;
            String studentID;
            Student student;
            Course course = courseService.FindByCollegeIDService(couCollegeID);
            if(course == null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            Attendance attendance = new Attendance();
            attendance.setCourseID(course.getCourseID());
            for(i = 1; i < 11; i+=1){
               studentID = req.getParameter("studentID"+i);
               if(studentID == null) continue;
               student = studentService.FindByCollegeIDService(studentID);
               if(student != null){
                   attendance.setStudentID(student.getStudentID());
                   attendanceService.SaveEntityWithoutIDService(attendance);
               }
               
            }
          
            try{
                res.sendRedirect("/add-data");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        else{
             try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
            }
        }
        
    }
    
}
