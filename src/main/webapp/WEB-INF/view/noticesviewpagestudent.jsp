


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
                <tr class="notices-hdg"> <%=i++%> . <%=t.getHeading() %></tr> 
                <tr class="notices-mini"> <%= t.getDescription()%> </tr>
                <tr class="notices-desc"> <%= t.getCompleteDescription()%> </tr>
                <tr class="notices-date">Date Created : <%= t.getDateCreated()%></tr>
           </table>
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
