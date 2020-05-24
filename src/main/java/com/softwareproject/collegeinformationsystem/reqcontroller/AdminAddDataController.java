/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.TimeTable;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.repository.TimeTableRepository;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.TimeTableService;
import java.sql.Date;
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
public class AdminAddDataController {
    
     @Autowired
     FacultyRepository facultyRepository;
     
     @Autowired
     StudentRepository studentRepository;
     
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
     
    @RequestMapping("/add-data-faculty")
    public void AdminAddDataFacultyFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataFacultyFunction is called in controller");
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
            String facName = req.getParameter("facName");
            String collegeID = req.getParameter("facID");
            String facDOBTemp = req.getParameter("facDOB");
            if(facName == null || collegeID == null || facDOBTemp == null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            
            Date facDOB = Date.valueOf(facDOBTemp);
            FacultyService facultyService = new FacultyService(facultyRepository);
            Faculty faculty = facultyService.FindByCollegeIDService(collegeID);
            if(faculty != null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            faculty = new Faculty();
            faculty.setCollegeID(collegeID);
            faculty.setName(facName);
            faculty.setDob(facDOB);
            facultyService.SaveEntityService(faculty);
            //redirect to same page
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
        
    @RequestMapping("/add-data-student")
    public void AdminAddDataStudentFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataStudentFunction is called in controller");
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
            String stuName = req.getParameter("stuName");
            String collegeID = req.getParameter("stuID");
            String stuDOBTemp = req.getParameter("stuDOB");
            if(stuName == null || collegeID == null || stuDOBTemp == null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            
            Date stuDOB = Date.valueOf(stuDOBTemp);
            StudentService studentService = new StudentService(studentRepository);
            Student student = studentService.FindByCollegeIDService(collegeID);
            if(student != null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            student = new Student();
            student.setCollegeID(collegeID);
            student.setName(stuName);
            student.setDob(stuDOB);
            studentService.SaveEntityService(student);
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
    
    @RequestMapping("/add-data-course")
    public void AdminAddDataCourseFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataCourseFunction is called in controller");
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
            String couName = req.getParameter("couName");
            String collegeID = req.getParameter("collegeID");
            String facCollegeID = req.getParameter("facCollegeID");
            if(couName == null || collegeID == null || facCollegeID == null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            CourseService courseService = new CourseService(courseRepository);
            FacultyService facultyService = new FacultyService(facultyRepository);
            Course course = courseService.FindByCollegeIDService(collegeID);
            if(course!= null){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            course = new Course();
            course.setCourseName(couName);
            course.setFacultyCollegeID(facCollegeID);
            course.setCollegeID(collegeID);
            Faculty faculty = facultyService.FindByCollegeIDService(facCollegeID);
            course.setFacultyID(faculty.getFacultyID());
            courseService.SaveEntityService(course);
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
    
    @RequestMapping("/add-data-timetable")
    public void AdminAddDataTimeTableFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("AdminAddDataTimeTableFunction is called in controller");
        boolean check = checkLogin(req);//works for update as well as create
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
            String venue1 = req.getParameter("venue1");
            String venue2 = req.getParameter("venue2");
            String venue3 = req.getParameter("venue3");
            String venue4 = req.getParameter("venue4");
            String timingsStr1 = req.getParameter("timings1");
            String timingsStr2 = req.getParameter("timings2");
            String timingsStr3 = req.getParameter("timings3");
            String timingsStr4 = req.getParameter("timings4");
            if( couCollegeID == null ){
                try{
                    res.sendRedirect("/home");
                }
                catch(Exception e){
                    System.out.println(e +" -error");
                }
            }
            CourseService courseService = new CourseService(courseRepository);
            TimeTableService timeTableService = new TimeTableService(timeTableRepository);
            Course course = courseService.FindByCollegeIDService(couCollegeID);
            TimeTable timeTable = timeTableService.FindByCourseIDService(course.getCourseID());
            if(timeTable!= null){
                timeTableService.DeleteByIDService(timeTable.getTimetableID());
            }
            timeTable = new TimeTable();
            timeTable.setVenue1(venue1);
            timeTable.setVenue2(venue2);
            timeTable.setVenue3(venue3);
            timeTable.setVenue4(venue4);
            timeTable.setTimings1(Integer.parseInt(timingsStr1));
            timeTable.setTimings2(Integer.parseInt(timingsStr2));
            timeTable.setTimings3(Integer.parseInt(timingsStr3));
            timeTable.setTimings4(Integer.parseInt(timingsStr4));
           timeTable.setCourseID(course.getCourseID());
           timeTableService.SaveEntityService(timeTable);
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
