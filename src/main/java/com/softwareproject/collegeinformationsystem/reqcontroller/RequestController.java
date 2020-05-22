
package com.softwareproject.collegeinformationsystem.reqcontroller;


/**
 *
 * @author aerus02
 */

import com.softwareproject.collegeinformationsystem.model.User;
import com.softwareproject.collegeinformationsystem.model.Course;
import com.softwareproject.collegeinformationsystem.model.Student;
import com.softwareproject.collegeinformationsystem.model.Faculty;

import com.softwareproject.collegeinformationsystem.repository.AdminRepository;
import com.softwareproject.collegeinformationsystem.repository.AttendanceRepository;
import com.softwareproject.collegeinformationsystem.repository.CourseRepository;
import com.softwareproject.collegeinformationsystem.repository.FacultyRepository;
import com.softwareproject.collegeinformationsystem.repository.StudentRepository;
import com.softwareproject.collegeinformationsystem.repository.TimeTableRepository;
import com.softwareproject.collegeinformationsystem.repository.UserRepository;

import com.softwareproject.collegeinformationsystem.services.AdminService;
import com.softwareproject.collegeinformationsystem.services.AttendanceService;
import com.softwareproject.collegeinformationsystem.services.CourseService;
import com.softwareproject.collegeinformationsystem.services.FacultyService;
import com.softwareproject.collegeinformationsystem.services.StudentService;
import com.softwareproject.collegeinformationsystem.services.UserService;
import com.softwareproject.collegeinformationsystem.services.TimeTableService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RequestController {
    
    //code for prevent cache?
    
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
    
    
    
    
    @RequestMapping("/logout")
     public String LogoutFunction(HttpServletRequest req,HttpServletResponse res) throws IOException{
        HttpSession session = req.getSession();
//        session.setAttribute("username", null);
//        session.setAttribute("password",null);
//        session.setAttribute("userType",0);
        
        session.invalidate();
        
        //res.sendRedirect("login");
        return "index";
    }
     
    @RequestMapping("/change-password")
     public String ChangePasswordFunction(@RequestParam("password") String pword,HttpServletRequest req,HttpServletResponse res) throws IOException{
        HttpSession session = req.getSession();
        //process it.-take username and curopass aswell
//        session.setAttribute("username", null);
//        session.setAttribute("password",null);
//        session.setAttribute("userType",0);
        
        
        res.sendRedirect("login");
        return "index";
    }
     
     
     
    
    @RequestMapping("/home")
    public String homeFunction(HttpServletRequest req,HttpServletResponse res) throws IOException{
        
        String username = (String)req.getParameter("username") ;
        String password = (String)req.getParameter("password") ;
        System.out.println("HomeFunction is called");
        System.out.println(username +" "+ password);
        
        HttpSession session = req.getSession();
        //added lately
        if((session == null ||password == null || username == null)  && session.getAttribute("username") != null && session.getAttribute("password")!= null){
            if((int)session.getAttribute("userType") == 1){
                return "homepageadmin";
            }
            else if((int)session.getAttribute("userType") == 2){
                return "homepagefaculty";
            }
            else return "homepagestudent";
        }//added lately
       
        session.setAttribute("username",username);
        session.setAttribute("password",password); 
        
        res.setHeader("Cache-Control","must-revalidate");
        //res.setHeader("Cache-Control","no-cache,no-store");//,must-revalidate");   
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(password != null && username != null && !password.equals("") && !username.equals("")){
            
            UserService userService = new UserService(userRepository);
            AdminService adminService = new AdminService(adminRepository);
            FacultyService facultyService = new FacultyService(facultyRepository);
            StudentService studentService = new StudentService(studentRepository);
            
            List<User> list = userService.SearchUserByUsernameService(user);
            if(list != null){
                User listUser;
                String str;
                int j;
                for(int i = 0; i < list.size();i+=1){
                    listUser = list.get(i);
                    if(listUser.getPassword().equals(user.getPassword())){//1-admin,2-faculty,3-stu
                        user = listUser;
                        if(adminService.ExistByUserIDService(listUser.getUserID()))  j = 1;                          
                        else if(facultyService.ExistByUserIDService(listUser.getUserID())){
                            j = 2;
                            Faculty faculty = facultyService.FindByUserIDService(user.getUserID());
                            session.setAttribute("name",faculty.getName());
                        }
                        else{
                            j = 3;
                            Student student = studentService.FindByUserIDService(user.getUserID());
                            session.setAttribute("name",student.getName());
                        }
                        session.setAttribute("userType",j);
                        switch(j){
                            case 1 :
                                str = "homepageadmin";
                                break;
                            case 2:
                                str = "homepagefaculty";
                                break;
                            case 3:
                                str = "homepagestudent"; 
                                break;
                            default :
                                str = "homepagestudent";
                        }
                        return str;
                    }
                }            
            }
               
        }
       try{
           res.sendRedirect("/login");
       }
       catch(Exception e){
           System.out.println("Error" + e);
       }    
        return "index";
    }
    
    
    
    
    @RequestMapping("/login")
    public String loginFunction(HttpServletRequest req){
        System.out.println("loginFunction is called");
        return "index";
    }
    
    
    
    
     @RequestMapping("/")
    public String OtherloginFunction(HttpServletRequest req,HttpServletResponse res) throws IOException{
        try{
           res.sendRedirect("login");
        }
        catch(Exception e){
            System.out.println("Error" + e);
        }    
        return "index";    
    }
    
    
    
    /*
    @RequestMapping("/register")//use try cattch every where to check if logged in and valid entry in form
    public String registerFunction(User user){
        System.out.println("registerFunction is called");
        UserService userService = new UserService(userRepository);
        System.out.println("userService initialised");
        userService.SaveUser(user);
        System.out.println("user saved");
        return "homepagestudent";
    }
    */
    
    
    
    @RequestMapping("/courses-list")
    public ModelAndView CoursesListFunction(HttpServletRequest req,HttpServletResponse res){
       System.out.println("CoursesListFunction is called in controller");
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
        System.out.println("CoursesListFunction is called in controller after login check");
        
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println((String)session.getAttribute("username") + (String)session.getAttribute("password"));
        
        
        UserService userService = new UserService(userRepository);
        StudentService studentService = new StudentService(studentRepository);
        AttendanceService attendanceService = new AttendanceService(attendanceRepository);
        CourseService courseService = new CourseService(courseRepository);
        FacultyService facultyService = new FacultyService(facultyRepository);
        System.out.println("CoursesListFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        if((Integer)session.getAttribute("userType") == 1){
            List<Course> coursesList = courseService.FindAllService();
            mv = new ModelAndView("courseslistpageadmin");
            mv.addObject("coursesList",coursesList);
            
        }
        
        else if((Integer)session.getAttribute("userType") == 2){
            Faculty faculty = facultyService.FindByUserIDService(user.getUserID());
            int facultyID = faculty.getFacultyID();
            
            List<Course> coursesList = courseService.FindByFacultyIDService(facultyID);
            mv = new ModelAndView("courseslistpagefaculty");
            mv.addObject("coursesList",coursesList);
        }
        
        else{
            Student student  = studentService.FindByUserIDService(user.getUserID());
            int studentID = student.getStudentID();

            List<Integer> courseIDs = attendanceService.FindCourseIDsByStudentIDService(studentID);
            List<Course> coursesList = courseService.FindByCourseIDListService(courseIDs);
            mv = new ModelAndView("courseslistpagestudent");
            mv.addObject("coursesList",coursesList);
        }
        return mv;
    }
    
    
    
    @RequestMapping("/faculties-list")
    public ModelAndView FacultyListFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("FacultyListFunction is called in controller");
        boolean check = checkLogin(req);
        if(!check){
            try{
                res.sendRedirect("login");
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
        System.out.println("FacultiesListFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        if((Integer)session.getAttribute("userType") == 1){
            List<Faculty> facultiesList = facultyService.FindAllService();
            mv = new ModelAndView("facultieslistpageadmin");
            mv.addObject("facultiesList",facultiesList);
            
        }
        else if((Integer)session.getAttribute("userType") == 3){
            Student student  = studentService.FindByUserIDService(user.getUserID());
            int studentID = student.getStudentID();

            List<Integer> courseIDs = attendanceService.FindCourseIDsByStudentIDService(studentID);
            List<Integer> facultyIDs = courseService.FindFacultyIDsByCourseIDsService(courseIDs);
            List<Faculty>facultiesList = facultyService.FindByFacultyIDsService(facultyIDs);
            
            mv = new ModelAndView("facultieslistpagestudent");
            mv.addObject("facultiesList",facultiesList);
        }
        else{
            try{
            res.sendRedirect("/login");//redirecting to login without removing session attribs
            }
            catch(Exception e){
                System.out.println("Exception occured in fetching facultylist");
            }
            mv = new ModelAndView("index");
        }
        return mv;     
    }
    
    
    
    @RequestMapping("/students-list")
    public ModelAndView StudentListFunction(HttpServletRequest req,HttpServletResponse res){
     
        System.out.println("StudentListFunction is called in controller");
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
        System.out.println("StudentsListFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        if(null == (Integer)session.getAttribute("userType")){
            try{
                res.sendRedirect("/login");//redirecting to login without removing session attribs
            }
            catch(Exception e){
                System.out.println("Exception occured in fetching studentslist");
            }
            mv = new ModelAndView("index");
        }
        else switch ((Integer)session.getAttribute("userType")) {
            case 1:
                {
                    List<Student> studentsList = studentService.FindAllService();
                    mv = new ModelAndView("studentslistpageadmin");
                    mv.addObject("studentsList",studentsList);
                    break;
                }
            case 2:
                {//Displays all students for a faculty,for one course,specify
                    Faculty faculty  = facultyService.FindByUserIDService(user.getUserID());
                    int facultyID = faculty.getFacultyID();
                    List<Integer> courseIDs = courseService.FindCourseIDsByFacultyIDService(facultyID);
                    List<Integer> studentIDs = attendanceService.FindStudentIDsByCourseIDsService(courseIDs);
                    List<Student> studentsList = studentService.FindByIDListService(studentIDs);
                    mv = new ModelAndView("studentslistpagefaculty");
                    mv.addObject("studentsList",studentsList);
                    break;
                }
            default:
                try{
                    res.sendRedirect("/login");//redirecting to login without removing session attribs
                }
                catch(Exception e){
                    System.out.println("Exception occured in fetching studentslist");
                }   mv = new ModelAndView("index");
                break;
        }
        return mv;          
    }
    
    
    
    @RequestMapping("/timetable")
    public ModelAndView TimeTableFunction(HttpServletRequest req,HttpServletResponse res){
        System.out.println("TimeTableFunction is called in controller");
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
        System.out.println("TimetableFunction ,before logic begins");
        User user = userService.FindByUsernameService(username);
        ModelAndView mv;
        int userType = (int)session.getAttribute("userType");
        if(userType == 2){
            Faculty faculty = facultyService.FindByUserIDService(user.getUserID());
            List<Integer> courseIDs = courseService.FindCourseIDsByFacultyIDService(faculty.getFacultyID());
            ArrayList<ArrayList<Integer>> timeTable = timeTableService.FindTimeTableByCourseIDsService(courseIDs);
            mv = new ModelAndView("timetablepagefaculty");
            List<Course>courses = courseService.FindByCourseIDListService(courseIDs);
            mv.addObject("courses",courses);
            mv.addObject("timeTable",timeTable);
            return mv;
            
        }
        else if(userType == 3){
            Student student = studentService.FindByUserIDService(user.getUserID());
            List<Integer> courseIDs = attendanceService.FindCourseIDsByStudentIDService(student.getStudentID());
            ArrayList<ArrayList<Integer>> timeTable = timeTableService.FindTimeTableByCourseIDsService(courseIDs);
            mv = new ModelAndView("timetablepagestudent");
            List<Course>courses = courseService.FindByCourseIDListService(courseIDs);
            mv.addObject("courses",courses);
            mv.addObject("timeTable",timeTable);
            return mv;
        }
        else{
            mv = new ModelAndView("homepageadmin");
        }
        return mv;
        
    }
   
    
    
    
    
    
    
}

