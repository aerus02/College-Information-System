
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="java.util.List" %>




<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
             <link href="css/homepagestyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Attendance</title>
        </head>
        <style>
            
        </style>
        <body>
            <header class="top1">Welcome,You are logged in as ${name}</header>

            <nav class="top2">
            	<div id="nav-bar-div">
            		<ul>
            			<li><a href="/logout">Logout</a></li>
            			<li><a href="/change-password">Change Password</a></li>
                                <li><a href="/home">Home</a></li>
                        </ul>
            	</div>

            </nav>
               
            <div class="middle">
                <div style="height:50px;"></div>
                <div class="title">Courses List for Attendance</div>
            <table class="tab">
                <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Course Name</th>
                <th class="table-cells2">Course ID</th>
                <th class="table-cells3">View Attendance</th>
                </tr>
            <% 
                int i = 1;
                List<Course> courses = (List<Course>)request.getAttribute("courLis");

                if(courses != null){
            %>
           
            <%
            for(Course c: courses){
            %>
            <tr>
                <td class="index"> <%=i++%> </td> 
                <td class="table-cells1"> <%= c.getCourseName()%></td>
                <td class="table-cells2"> <%= c.getCollegeID()%> </td>
                <td class="table-cells3">
                    <form action="/attendance" method="POST">
                        <input type="hidden" name="courseID" value=<%=c.getCourseID()%> />
                        <button class="btn">View Attendance </button>
                    </form>
                </td>
             </tr>
          <%  }
            %>
            </table>
            <%}
            else{
            %>
            <div class="nildata">No courses to display </div>
            <% }%>
            
            </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>
            
        </body>
    </html>
