/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Notice;
import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.repository.NoticeRepository;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;
import com.softwareproject.collegeinformationsystem.services.AttendanceService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.NoticeService;
import com.softwareproject.collegeinformationsystem.services.UserService;

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
public class NoticeViewController {
    //One notice per class(Course->0)or for all-(0),def :-1;
    //admin-shows all,student,faculty-courses related
    //displaying to be managed in frontend
    
    
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
    
    
    @RequestMapping("/notices-view")//should also send courseID for fac -is string
    public ModelAndView NoticesViewFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("NoticesViewFunction is called in controller");
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
        NoticeService noticeService = new NoticeService(noticeRepository);
        System.out.println("NoticesViewFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        
        //convert string collegeid for course to courseid
        List<Notice> notices;
        if(userType == 1){
            notices = noticeService.FindByCourseIDService(0);
            mv = new ModelAndView("noticesviewpageadmin");
            mv.addObject(notices);
            return mv;
        
        }
        else if(userType == 2){
            Faculty faculty = facultyService.FindByUserIDService(user.getUserID());
            List<Integer>courseIDs = courseService.FindCourseIDsByFacultyIDService(faculty.getFacultyID());
            notices = noticeService. FindNoticesByCourseIDsService(courseIDs);
            mv = new ModelAndView("noticesviewpagefaculty");
            mv.addObject(notices);
            return mv;
            
        }
        else{
            Student student = studentService.FindByUserIDService(user.getUserID());
            List<Integer>courseIDs = attendanceService.FindCourseIDsByStudentIDService(student.getStudentID());
            notices = noticeService.FindNoticesByCourseIDsService(courseIDs);
            mv = new ModelAndView("noticesviewpagestudent");
            mv.addObject(notices);
            return mv;
        }
    }
 
    
}
