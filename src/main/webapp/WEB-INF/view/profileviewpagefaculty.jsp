

<%@page import="com.softwareproject.collegeinformationsystem.model.Faculty" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Profile</title>
        </head>
        <body>
            <h1>This is profile view faculty page</h1>
            

                ${faculty}
                
                <% 
                
                Faculty f = (Faculty)request.getAttribute("faculty");
            %>
            <%
            if(f != null){
            %>
            <table>
            <tr>
                <td>Name </td> 
                <td> <%= f.getName()%> </td>
            </tr>
            <tr>
                <td> CollegeID </td>
                <td> <%= f.getCollegeID()%> </td>
            </tr>
            <tr>
                <td> Date of Birth </td>
                <td> <%= f.getDob()%> </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td> <%= f.getGender()%> </td>
            </tr>
            <tr>
                <td> Department</td>
                <td> <%= f.getDepartment()%> </td>
            </tr>
            <tr>
                <td> Phone Number </td>
                <td> <%= f.getPhoneNumber()%> </td>
            </tr>
            <tr>
                <td> Email ID</td>
                <td> <%= f.getMailID()%> </td>
            </tr>
            <tr>
                <td> Date of Joining</td>
                <td> <%= f.getDoj()%> </td>
            </tr>
            <tr>
                <td> Date of Leaving</td>
                <td> <%= f.getDol()%> </td>
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

        </body>
    </html>
