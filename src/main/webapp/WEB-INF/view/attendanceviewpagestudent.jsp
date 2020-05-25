

<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="java.util.List" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/attendanceviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Attendance</title>
        </head>
        <body>
            <%
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires",0);
            response.setHeader("Pragma","no-cache");
            if(session.getAttribute("name") == null)
                response.sendRedirect("/home");
            %>
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
                <div class="title">Attendance</div>
            <% 
                int i = 1;
                List<Course> courses = (List<Course>)request.getAttribute("coursesList");
                List<List<Integer> > attendance = (List<List<Integer> >)request.getAttribute("attendance");
                
                if(courses != null){
            %>
            
             <table class="tab">
                 <% if((int)request.getAttribute("month") == 1){%>
                <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Course Name</th>
                <th class="table-cells2">Course ID</th>
                <th class="table-cells3">January</th>
                <th class="table-cells4">February</th>
                <th class="table-cells5">March</th>
                <th class="table-cells6">April</th>
                </tr>
                <%}else{%>
                <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Course Name</th>
                <th class="table-cells2">Course ID</th>
                <th class="table-cells3">August</th>
                <th class="table-cells4">September</th>
                <th class="table-cells5">October</th>
                <th class="table-cells6">November</th>
                </tr>
                <%}%>
            <%
            for(Course c: courses){
            %>
            <tr>
                <td class="index"> <%=i++%> </td> 
                <td class="table-cells1"> <%= c.getCourseName()%> </td>
                <td class="table-cells2"> <%= c.getCollegeID()%> </td>
                <td class="table-cells3"> <%= attendance.get(i-2).get(0)%> %</td>
                <td class="table-cells4"> <%= attendance.get(i-2).get(1)%> %</td>
                <td class="table-cells5"> <%= attendance.get(i-2).get(2)%> %</td>
                <td class="table-cells6"> <%= attendance.get(i-2).get(3)%> %</td>
             </tr>
          <%  }
            %>
            
            </table>
            <div class="desc">These are your course wise and month wise attendance percentages</div>
            <%}
            else{
            %>
            <div class="nildata">No attendance data to display </div>
            <% }%>
            </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>

        </body>
    </html>
