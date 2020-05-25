


<%@page import="com.softwareproject.collegeinformationsystem.model.Notice" %>
<%@page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            
            <link href="css/studentprofileviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Notices</title>
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
                <div class="title">Notices</div>
            

                
            <% 
                int i = 1;
                List<Notice> notices = (List<Notice>)request.getAttribute("notices");
                
            %>
            <%
            if(notices != null){
            for(Notice t: notices){
            %>
            <table class="notices-tab">
                <tr class="notices-hdg"> 
                    <th>Title </th>
                <td><div class="notice-cls"><%=i++%> . <%=t.getHeading() %></div></td></tr> 
            <tr class="notices-mini"> 
                    <th>Short Description </th>
                <td> <div class="notice-cls"><%= t.getDescription()%> </div></td></tr>
                <tr class="notices-desc"> 
                    <th>Notice </th>
                <td><div class="notice-cls"><%= t.getCompleteDescription()%> </div></td></tr>
                <tr class="notices-date"> 
                    <th>Date Created : </th>
                    <td><div class="notice-cls"> <%= t.getDateCreated()%></div></td></tr>
           </table>
           
             <br>
             <br>
            <%  }}else{
            %>
            <div class="nildata">No notices to display</div>
             <%}%>
              </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	
            

        </body>
    </html>
