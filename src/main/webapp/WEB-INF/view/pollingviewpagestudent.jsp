

<%@page import="com.softwareproject.collegeinformationsystem.model.Polling" %>
<%@page import="java.util.List" %>





<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/pollingviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Polling</title>
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
                <div class="title">Polls</div>
            

                
            <% 
           int i = 1;
           List<Polling> polls = (List<Polling>)request.getAttribute("polls");
           int studentID = (int)request.getAttribute("studentID");
            %>
            <%
            if(polls != null){
            for(Polling t: polls){
            %>
                <div class="poll-box">
                <div class="poll-hea"> <%=i++%> . <%=t.getHeading() %></div>
                <div class="poll-desc"> <%= t.getDescription()%></div>
                
                <div class="poll-opts">
                <form action="/polling-participate" method="POST" >
                    <input type="hidden" name="pollID" value="<%= t.getPollID()%>">
                    <input type="hidden" name="studentID" value="<%= studentID%>">
                
                <input type="radio" name="option" value="1">
                <label><%= t.getOption1()%></label><br>
                
                <input type="radio" name="option" value="2">
                <label><%= t.getOption2()%></label><br>
                
                <input type="radio" name="option" value="3">
                <label><%= t.getOption3()%></label><br>
                
                <input type="radio" name="option" value="4">
                <label><%= t.getOption4()%></label><br>
                <button class="btn-poll" onclick="alert('Details Submitted')">Send poll option </button>
                </form>
                </div>
                <div class="poll-date">
                Date Created : <%= t.getDateCreated()%>
                </div>
                </div>
           
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
