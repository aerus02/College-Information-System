
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-courses-list</title>
        </head>
        <body>
            <h1>This is courses-list page</h1>
            
                <h1>Welcome,you are logged in as ${username} </h1>
            
             <table>
            <% 
                int i = 1;
                List<Course> courses = (List<Course>)request.getAttribute("coursesList");
                //if possible,sort.
            %>
            <%
            for(Course c: courses){
            %>
            <tr>
                <!--set view course profile here-facName,strength,timetable-->
                <td> <%=i++%> </td> 
                <td> <%= c.getCourseName()%></td>
                <td> <%= c.getCollegeID()%> </td>
                <td>
                    <form action="/course-profile?courseID="+<%=c.getCourseID()%> >
                        <button>View Profile </button>
                    </form>
                </td>
             </tr>
          <%  }
            %>
            </table>
        </body>
    </html>
