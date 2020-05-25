
<%@page import="com.softwareproject.collegeinformationsystem.model.Faculty" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/studentprofileviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Profile</title>
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
                <div class="title">Profile</div>  
                <% 
                
                Faculty f = (Faculty)request.getAttribute("faculty");
            %>
            <%
            if(f != null){
            %>
            <table class="tab">
            <tr>
                <th>Name </th> 
                <td> <%= f.getName()%> </td>
            </tr>
            <tr>
                <th> Faculty ID </th>
                <td> <%= f.getCollegeID()%> </td>
            </tr>
                <th> Department</th>
                <td> <%= f.getDepartment()%> </td>
            </tr>
            <tr>
                <th> Email ID</th>
                <td> <%= f.getMailID()%> </td>
            </tr>
            <tr>
                <th> Date of Joining</th>
                <td> <%= f.getDoj()%> </td>
            </tr>
             
            </table>
            <%
                }
            else{
            %>
            <h3 class="nildata">No Profile data to Display</h3>
            <%
                }
            %>
             </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	
            

        </body>
    </html>
