
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="com.softwareproject.collegeinformationsystem.model.TimeTable" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-course-profile</title>
        </head>
        <body>
            <h1>This is courses-list page</h1>
            
                <h1>Welcome,you are logged in as ${username} </h1>
            
            <h2>Course Profile </h2>  
            <%
            Course course = (Course)request.getAttribute("course");
            TimeTable timeTable = (TimeTable)request.getAttribute("timeTable");
            %>
            
            Course Name : ${course.getCourseName()}
            FacultyName :   ${facultyName}
            CourseID    : ${course.getCourseID()}
            TimeTable  : 
            
            <%  if(timeTable.getVenue1() != null) 
            %>
            <%= timeTable.getVenue1()%>
            <%  if(timeTable.getVenue2() != null) 
            %>
            <%= timeTable.getVenue2()%>
            <%  if(timeTable.getVenue3() != null) 
            %>
            <%= timeTable.getVenue3()%>
            <%  if(timeTable.getVenue4() != null) 
            %>
            <%= timeTable.getVenue4()%>
            
                
                
            
        </body>
    </html>
