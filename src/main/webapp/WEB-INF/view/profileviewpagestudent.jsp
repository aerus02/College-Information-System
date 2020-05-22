


<%@page import="com.softwareproject.collegeinformationsystem.model.Student" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Profile</title>
        </head>
        <body>
            <h1>This is profileview student page</h1>
            
            
            <% 
                
                Student s = (Student)request.getAttribute("student");
            %>
            <%
            if(s != null){
            %>
            <table>
            <tr>
                <td>Name </td> 
                <td> <%= s.getName()%> </td>
            </tr>
            <tr>
                <td> CollegeID </td>
                <td> <%= s.getCollegeID()%> </td>
            </tr>
            <tr>
                <td> Date of Birth </td>
                <td> <%= s.getDob()%> </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td> <%= s.getGender()%> </td>
            </tr>
            <tr>
                <td> Department</td>
                <td> <%= s.getDepartment()%> </td>
            </tr>
            <tr>
                <td> Phone Number </td>
                <td> <%= s.getPhoneNumber()%> </td>
            </tr>
            <tr>
                <td> Email ID</td>
                <td> <%= s.getMailID()%> </td>
            </tr>
            <tr>
                <td> Year of Enrollment</td>
                <td> <%= s.getYearOfEnrollment()%> </td>
            </tr>
            <tr>
                <td> Enrolled Course</td>
                <td> <%= s.getEnrolledCourse()%> </td>
            </tr>
             
            </table>
            <%
                }
            else{
            %>
            <h3>No Profile to Display</h3>
            <%
                }
            %>
            
        </body>
    </html>
