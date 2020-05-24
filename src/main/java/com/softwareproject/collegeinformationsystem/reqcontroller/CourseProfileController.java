/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.TimeTable;
import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.TimeTableRepository;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.TimeTableService;
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
public class CourseProfileController {
    
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    TimeTableRepository timeTableRepository;
    
    
     @Autowired
     FacultyRepository facultyRepository;
     
    
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
    
    @RequestMapping("/course-profile")
    public ModelAndView CourseProfileFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("Course-ProfileFunction is called in controller");
        boolean check = checkLogin(req);
        String str = (String)req.getParameter("courseID");
        int courseID = 1;
        if(str != null)courseID = Integer.parseInt(str);
        System.out.println(str+check);
        if(str == null || !check){
            try{
                res.sendRedirect("/login");
            }
            catch(Exception e){
                System.out.println(e +" -error");
                return new ModelAndView("index");
            }
        }
        
        CourseService courseService = new CourseService(courseRepository);
        TimeTableService timeTableService = new TimeTableService(timeTableRepository);
        FacultyService facultyService = new FacultyService(facultyRepository);
        Course course = courseService.FindByCourseIDService(courseID);
        ModelAndView mv = new ModelAndView("courseprofileviewpage");
        mv.addObject("course",course);
        Faculty faculty = facultyService.FindByIDService(course.getFacultyID());
//      mv.addObject("facultyName",faculty.getName());
        mv.addObject("faculty",faculty);
        TimeTable timeTable = timeTableService.FindByCourseIDService(courseID);
        mv.addObject("timeTable",timeTable);
        return mv;
    }
}
