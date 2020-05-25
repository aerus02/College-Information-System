
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
           List<List<Integer> >pollsCount = (List<List<Integer> >)request.getAttribute("pollListCounts");
            %>
            <%
            if(polls != null){
            for(Polling t: polls){
            %>
            <div class="poll-box">
            
                <div class="poll-hea">  <%=i++%> . <%=t.getHeading() %>   </div>
                 <div class="poll-desc">  <%= t.getDescription()%>    </div>
                  <div class="poll-opts">
                     <%= t.getOption1()%>   : 
                  <%= pollsCount.get(i-2).get(0)%>  <br>
                  <%= t.getOption2()%>    :
                  <%= pollsCount.get(i-2).get(1)%>  <br>
                  <%= t.getOption3()%>   :
                  <%= pollsCount.get(i-2).get(2)%>  <br>
                  <%= t.getOption4()%>   :
                  <%= pollsCount.get(i-2).get(3)%>  <br>
                   </div>
                  <div class="poll-date"> Date Created : <%= t.getDateCreated()%>  </div>
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
