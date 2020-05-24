
<%@page import="com.softwareproject.collegeinformationsystem.model.Student" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/studentprofileviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Student Profile</title>
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
                <div class="title">Student Profile</div>
            <% 
                
                Student s = (Student)request.getAttribute("student");
            %>
            <%
            if(s != null){
            %>
            <table class="tab">
            <tr>
                <th>Name </th> 
                <td> <%= s.getName()%> </td>
            </tr>
            <tr>
                <th> Student ID </th>
                <td> <%= s.getCollegeID()%> </td>
            </tr>
            <tr>
                <th> Date of Birth </th>
                <td> <%= s.getDob()%> </td>
            </tr>
            <tr>
                <th>Gender</th>
                <td> <%= s.getGender()%> </td>
            </tr>
            <tr>
                <th> Department</th>
                <td> <%= s.getDepartment()%> </td>
            </tr>
            <tr>
                <th> Phone Number </th>
                <td> <%= s.getPhoneNumber()%> </td>
            </tr>
            <tr>
                <th> Email ID</th>
                <td> <%= s.getMailID()%> </td>
            </tr>
            <tr>
                <th> Year of Enrollment</th>
                <td> <%= s.getYearOfEnrollment()%> </td>
            </tr>
            <tr>
                <th> Enrolled Course</th>
                <td> <%= s.getEnrolledCourse()%> </td>
            </tr>
             
            </table>
            <%
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
