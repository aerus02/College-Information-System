/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.repository.TimeTableRepository;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.services.AttendanceService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.TimeTableService;
import com.softwareproject.collegeinformationsystem.services.UserService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aerus02
 */
@Controller
public class AttendanceViewController {
    
    @Autowired
    UserRepository userRepository;
     
    @Autowired
    FacultyRepository facultyRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    AttendanceRepository attendanceRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    TimeTableRepository timeTableRepository;
    
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
    
    
     @RequestMapping("/attendance")//should also send courseID for fac -is string
    public ModelAndView AttendanceFunction(@RequestParam()int courseID,HttpServletRequest req,HttpServletResponse res){
        System.out.println("AttendanceFunction is called in controller");
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
        StudentService studentService = new StudentService(studentRepository);
        AttendanceService attendanceService = new AttendanceService(attendanceRepository);
        CourseService courseService = new CourseService(courseRepository);
        FacultyService facultyService = new FacultyService(facultyRepository);
        TimeTableService timeTableService = new TimeTableService(timeTableRepository);
        System.out.println("AttendanceFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        if(userType == 2 && courseID <= 0){
            try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("homepagefaculty");
            }
        }
        //convert string collegeid for course to courseid
        if(userType == 2){
            ArrayList<ArrayList<Integer>> attendance = attendanceService.FindFacultyAttendanceByCourseIDService(courseID);
            mv = new ModelAndView("attendanceviewpagefaculty");
            mv.addObject(attendance);
            return mv;//has studentid as 4th one ,0-3 as attendances
        }
        else if(userType == 3){
           Student student = studentService.FindByUserIDService(user.getUserID());
           
           ArrayList<ArrayList<Integer>> attendance = attendanceService.FindStudentAttendanceByStudentIDService(student.getStudentID());
           mv = new ModelAndView("attendanceviewpagestudent");
           mv.addObject(attendance);//has courseid as 4th one ,0-3 as attendances
           return mv;                
        
        }
        else{//redirect.
            try{
                res.sendRedirect("/home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("homepageadmin");
            }
            mv = new ModelAndView("homepageadmin");
            return mv;
        }
    }
    
}
