
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="com.softwareproject.collegeinformationsystem.model.Faculty" %>
<%@page import="com.softwareproject.collegeinformationsystem.model.TimeTable" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/studentprofileviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Course Profile</title>
        </head>
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
                <div class="title">Course Profile</div> 
            <%
            Course course = (Course)request.getAttribute("course");
            TimeTable timeTable = (TimeTable)request.getAttribute("timeTable");
            Faculty faculty = (Faculty)request.getAttribute("faculty");
            %>
             <%
            
		String [] strArray = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		String [] timeArray={"8.00-9.00","9.00-10.00","10.00-11.00","11.00-12.00","12.00-13.00","14.00-15.00","15.00-16.00","16.00-17.00","17.00-18.00"};
            if(course != null){
            %>
            <table class="tab">
            <tr>
                <th>Course Name</th> 
                <td> <%= course.getCourseName()%></td>
            </tr>
            <tr>
                <th>Course ID </th> 
                <td>  <%= course.getCollegeID()%></td>
            <tr>
                <th>Faculty Name </th> 
                <td>   <%= faculty.getName()%></td>
            <tr>
                <th>Faculty ID </th> 
                <td>  <%= faculty.getCollegeID()%></td>
            <tr>
                <th>Department </th> 
                <td>  <%= faculty.getDepartment()%></td>
            
            
            </table>
            <div class="coupro-title"> Time Table</div>
            <ol class="coupro-li">
                <!--timings start from 1 to 45-->
            <%  if(timeTable.getVenue1() != null){
                int temp1 = timeTable.getTimings1();
                String str1 = strArray[(temp1-1)/9]+" "+timeArray[(temp1-1)%9]+" ";
            %>
           <li><%=str1%> : <%= timeTable.getVenue1()%> </li>
            <%  }if(timeTable.getVenue2() != null){
                int temp1 = timeTable.getTimings2();
                String str1 = strArray[(temp1-1)/9]+" "+timeArray[(temp1-1)%9]+" ";

            %>
            <li><%=str1%> : <%= timeTable.getVenue2()%></li>
            <%  }if(timeTable.getVenue3() != null){ 
                int temp1 = timeTable.getTimings3();
                String str1 = strArray[(temp1-1)/9]+" "+timeArray[(temp1-1)%9]+" ";

            %>
            <li><%=str1%> : <%= timeTable.getVenue3()%></li>
            <%  }if(timeTable.getVenue4() != null){ 
                int temp1 = timeTable.getTimings4();
                String str1 = strArray[(temp1-1)/9]+" "+timeArray[(temp1-1)%9]+" ";

            %>
            <li><%=str1%> : <%= timeTable.getVenue4()%></li>
            </ol>
            <%}
                }
            else{
            %>
            <div class="nildata">No Profile data to Display</div>
            <%
                }
            %>
             </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	        
            
        </body>
    </html>
