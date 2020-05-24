/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.UserService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aerus02
 */
@Controller
public class RegistrationController {
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    FacultyRepository facultyRepository;
    
    @Autowired
    UserRepository userRepository;
    
    
    @RequestMapping("/register")
    public String registerFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("registerFunction is called");
        int pageType = Integer.parseInt(req.getParameter("pageType"));
        int dataType = Integer.parseInt(req.getParameter("dataType"));
        if(dataType != 1){//dataType==0
            switch (pageType) {
                case 0:
                    return "registerpage";
                case 1:
                    return "registerpagestudent";
                case 2:
                    return "registerpagefaculty";
                default:
                    break;
                   
            }
            return "index";
        }
        else{
            if(pageType == 1){
                String stuName = req.getParameter("stuname");
                String stuID = req.getParameter("stuid");
                String stuGender = req.getParameter("stugen");
                String stuDepartment = req.getParameter("studep");
                String stuDOBTem = req.getParameter("studob");
                String stuCourseEnrolled = req.getParameter("stuenrolcou");
                String stuMailID = req.getParameter("stumailid");
                String stuPhn = req.getParameter("stuphn");
                String stuYOE = req.getParameter("stuyoe");
                if(stuName == (null) || stuID == (null) ||stuGender == (null) ||stuDepartment == (null) ||stuDOBTem == (null) ||stuCourseEnrolled == (null) ||stuMailID == (null) ||stuPhn == (null) ||stuYOE == (null) ){
                    return "registerpagestudent";
                }
                
                 Date stuDOB = Date.valueOf(stuDOBTem);
                 Student student = new Student();
                 student.setName(stuName);
                 student.setCollegeID(stuID);
                 student.setGender(stuGender);
                 student.setDepartment(stuDepartment);
                 student.setDob(stuDOB);
                 student.setMailID(stuMailID);
                 student.setPhoneNumber(stuPhn);
                 student.setEnrolledCourse(stuCourseEnrolled);
                 student.setYearOfEnrollment(Integer.parseInt(stuYOE));
                 StudentService studentService = new StudentService(studentRepository);
                 UserService userService = new UserService(userRepository);
                 
                String username = req.getParameter("uname");
                String password = req.getParameter("password");
                String repassword = req.getParameter("repass");
                
                User user = userService.FindByUsernameService(username);
                if(username == null || password == null || repassword == null || !password.equals(repassword) || user != null){
                    return "registerpagestudent";
                }
                
                Student studentTemp = studentService.FindByCollegeIDService(stuID);
                if(studentTemp == null || !studentTemp.getName().equals(stuName) || !studentTemp.getDob().equals(stuDOB) || studentTemp.getUserID() >0) return "registerpagestudent";
                
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                int userID = userService.SaveEntityService(user);
                student.setUserID(userID);
                studentService.SaveEntityService(student);
                
                try{
                res.sendRedirect("/login");
                }
                catch(Exception e){
                    System.out.println(e +" -error");                    
                }
                return "index";
            }  
            else if(pageType == 2){
                String facName = req.getParameter("facname");
                String facID = req.getParameter("facid");
                String facGender = req.getParameter("facgen");
                String facDepartment = req.getParameter("facdep");
                String facDOBTem = req.getParameter("facdob");
                String facMailID = req.getParameter("facmailid");
                String facPhn = req.getParameter("facphn");
                String facDOJTem = req.getParameter("facyoe");
                if(facName == (null) || facID == (null) ||facGender == (null) ||facDepartment == (null) ||facDOBTem == (null)||facMailID == (null) ||facPhn == (null) ||facDOJTem == (null) ){
                    return "registerpagefaculty";
                }
                
                 Date facDOB = Date.valueOf(facDOBTem);
                 Date facDOJ = Date.valueOf(facDOJTem);
                 Faculty faculty = new Faculty();
                 faculty.setName(facName);
                 faculty.setCollegeID(facID);
                 faculty.setGender(facGender);
                 faculty.setDepartment(facDepartment);
                 faculty.setDob(facDOB);
                 faculty.setMailID(facMailID);
                 faculty.setPhoneNumber(facPhn);
                 faculty.setDoj(facDOJ);
                 FacultyService facultyService = new FacultyService(facultyRepository);
                 UserService userService = new UserService(userRepository);
                 
                String username = req.getParameter("uname");
                String password = req.getParameter("password");
                String repassword = req.getParameter("repass");
                
                User user = userService.FindByUsernameService(username);
                if(username == null || password == null || repassword == null || !password.equals(repassword) || user != null){
                    return "registerpagefaculty";
                }
                
                Faculty facultyTemp = facultyService.FindByCollegeIDService(facID);
                if(facultyTemp == null || !facultyTemp.getName().equals(facName) || !facultyTemp.getDob().equals(facDOB) || facultyTemp.getUserID() >0) return "registerpagefaculty";
                
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                int userID = userService.SaveEntityService(user);
                faculty.setUserID(userID);
                facultyService.SaveEntityService(faculty);
                
                try{
                res.sendRedirect("/login");
                }
                catch(Exception e){
                    System.out.println(e +" -error");                    
                }
                return "index";
            }
            else{
                try{
                res.sendRedirect("/login");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                    return "index";
                }
            }
            return "index";
        }
    }
    
}
