
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="java.util.List" %>




<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-attendance</title>
        </head>
        <body>
            <h1>This is attendance page</h1>
            
                
                  
            <% 
                int i = 1;
                List<Course> courses = (List<Course>)request.getAttribute("courLis");

                if(courses != null){
            %>
            <table>
            <%
            for(Course c: courses){
            %>
            <tr>
                <td> <%=i++%> </td> 
                <td> <%= c.getCourseName()%></td>
                <td> <%= c.getCollegeID()%> </td>
                <td>
                    <form action="/attendance-update?courseID="+<%=c.getCourseID()%> >
                        <button>View Attendance </button>
                    </form>
                </td>
             </tr>
          <%  }
            %>
            </table>
            <%}
            else{
            %>
            <h3>No courses to display </h3>
            <% }%>

        </body>
    </html>
