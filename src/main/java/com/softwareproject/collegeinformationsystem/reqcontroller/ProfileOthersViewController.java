/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.repository.AdminRepository;
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
import com.softwareproject.collegeinformationsystem.services.UserService;
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
public class ProfileOthersViewController {
    //for course,fac,stu,to display.
    //for student by fac,ad
    //for fac by stu,ad
    
     @Autowired
    UserRepository userRepository;
    
    @Autowired
    AdminRepository adminRepository;
     
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
    
    @RequestMapping("/others-profile")//should send type and collegeid
    public ModelAndView ProfileOthersFunction(@RequestParam("type")int type,@RequestParam("collegeID")String collegeID,HttpServletRequest req,HttpServletResponse res){
        System.out.println("ProfileOthersFunction is called in controller");
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
        //String username = (String)session.getAttribute("username");
        System.out.println((String)session.getAttribute("username") + (String)session.getAttribute("password"));
        
        
        StudentService studentService = new StudentService(studentRepository);
        FacultyService facultyService = new FacultyService(facultyRepository);
        System.out.println("ProfileOthersFunction ,before logic begins");
        if(type < 2 || collegeID == null){
            try{
                res.sendRedirect("home");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("index");
            }
        }
        ModelAndView mv;
        if(type == 2){
            Faculty faculty = facultyService.FindByCollegeIDService(collegeID);
            if(faculty == null || (int)session.getAttribute("userType") == 2){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return new ModelAndView("homepagefaculty");
                }
            }
            if((int)session.getAttribute("userType") == 1){
            mv = new ModelAndView("profileviewpagefaculty");
            }
            else{
            mv = new ModelAndView("profilefacultyviewpagestudent");
            }
            mv.addObject(faculty);
            return mv;
        }//profile displays name,colegeid,dob,courseenrolled-btec..,(couresenrolled,grade) - in other link ,redirects to courseslist,gender,mailid,phonenum,dept, 
        else if(type == 3){
            Student student = studentService.FindByCollegeIDService(collegeID);
            if(student == null || (int)session.getAttribute("userType") == 3){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return new ModelAndView("homepagestudent");
                }
            }
            if((int)session.getAttribute("userType") == 1){
                mv = new ModelAndView("profileviewpagestudent");
            }
            else{
//                mv = new ModelAndView("profilestudentviewpagefaculty");
                mv = new ModelAndView("profileviewpagestudent");
            }
            mv.addObject(student);
            return mv;
        }
        else{
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
