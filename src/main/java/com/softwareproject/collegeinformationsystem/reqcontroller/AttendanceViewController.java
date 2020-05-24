/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareproject.collegeinformationsystem.reqcontroller;

import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.Faculty;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.Attendance;
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
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;

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
    public ModelAndView AttendanceFunction(HttpServletRequest req,HttpServletResponse res){
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
        //for fac,displays courses list,from there to indiv attendance and update
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
//        if(userType == 2 && courseID <= 0){
//            try{
//                res.sendRedirect("/home");
//            }
//            catch(Exception e){
//                System.out.println(e +" -error");
//                return new ModelAndView("homepagefaculty");
//            }
//        }
        if(userType == 2){
            // ArrayList<ArrayList<Integer>> attendance = attendanceService.FindFacultyAttendanceByCourseIDService(courseID);
            String courseIDString =req.getParameter("courseID");
            
            if(courseIDString == null){
                mv = new ModelAndView("attendanceviewpagefaculty");
                Faculty faculty = facultyService.FindByUserIDService(user.getUserID());
                int facultyID = faculty.getFacultyID();

                System.out.println("In attendance controller fac");
                List<Course> coursesList = courseService.FindByFacultyIDService(facultyID);

                mv.addObject("courLis",coursesList);
                return mv;//has studentid as 4th one ,0-3 as attendances
            }
            else{
                int courseID = Integer.parseInt(courseIDString);
                String updateReq =req.getParameter("updateReq");
                if(updateReq == null){
                    mv = new ModelAndView("attendanceupdatepagefaculty");
                    ArrayList<ArrayList<Integer>> attendance = attendanceService.FindFacultyAttendanceByCourseIDService(courseID);
                    mv.addObject("attendance",attendance);
                    ArrayList<Integer> stuIDList = new ArrayList<Integer> ();
                    for(int i = 0; i < attendance.size();i+=1){
                        stuIDList.add(i,attendance.get(i).get(4));
                    }
                    List<Student> students = studentService.FindByIDListService(stuIDList);
                    mv.addObject("studentsList",students);
                    mv.addObject("courseID",courseID);
                    Date date= new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int month = cal.get(Calendar.MONTH);
                    if(month <= 5) mv.addObject("month",1);
                    else mv.addObject("month",2);
                    return mv;
                }
                else{//should also send courseID
                    int att1,att2,att3,att4;
                    mv = new ModelAndView("attendanceupdatepagefaculty");
                    mv.addObject("courseID",courseID);
                    att1 = Integer.parseInt(req.getParameter("att1"));
                    att2 = Integer.parseInt(req.getParameter("att2"));
                    att3 = Integer.parseInt(req.getParameter("att3"));
                    att4 = Integer.parseInt(req.getParameter("att4"));
                    int StudentID = Integer.parseInt(req.getParameter("studentID"));
                    Attendance attendanceTemp = new Attendance();
                    attendanceTemp.setCourseID(courseID);
                    attendanceTemp.setValue1(att1);           
                    attendanceTemp.setValue2(att2);
                    attendanceTemp.setValue3(att3); 
                    attendanceTemp.setValue4(att4);
                    attendanceTemp.setStudentID(StudentID);
                    attendanceService.UpdateEntityService(attendanceTemp);
                    ArrayList<ArrayList<Integer>> attendance = attendanceService.FindFacultyAttendanceByCourseIDService(courseID);
                    mv.addObject("attendance",attendance);
                    ArrayList<Integer> stuIDList = new ArrayList<Integer> ();
                    for(int i = 0; i < attendance.size();i+=1){
                        stuIDList.add(i,attendance.get(i).get(4));
                    }
                    List<Student> students = studentService.FindByIDListService(stuIDList);
                    mv.addObject("studentsList",students);
                    Date date= new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    int month = cal.get(Calendar.MONTH);
                    if(month <= 5) mv.addObject("month",1);
                    else mv.addObject("month",2);
                    return mv;
                }
            }
        }
        else if(userType == 3){
           Student student = studentService.FindByUserIDService(user.getUserID());
           
           ArrayList<ArrayList<Integer>> attendance = attendanceService.FindStudentAttendanceByStudentIDService(student.getStudentID());
           ArrayList<Integer> courseIDs = new ArrayList<>();
           List<Course>coursesList;
           if(attendance != null){
                for(int i = 0; i < attendance.size();++i){
                    courseIDs.add(i,attendance.get(i).get(4));
                }   
                coursesList = courseService.FindByCourseIDListService(courseIDs);
           }
           else coursesList = null;
//           long d = System.currentTimeMillis();
//           Date date = new Date(d);
            

            Date date= new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);

           mv = new ModelAndView("attendanceviewpagestudent");
           if(month <= 5) mv.addObject("month",1);
           else mv.addObject("month",2);
           mv.addObject("attendance",attendance);//has courseid as 4th one ,0-3 as attendances
           mv.addObject("coursesList",coursesList);
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
