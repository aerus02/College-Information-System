

<%@page import="com.softwareproject.collegeinformationsystem.model.Polling" %>
<%@page import="java.util.List" %>





<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Polling</title>
        </head>
        <body>
            <h1>This is polling page -student</h1>
            

                
            <% 
           int i = 1;
           List<Polling> polls = (List<Polling>)request.getAttribute("polls");
          
            %>
            <%
            if(polls != null){
            for(Polling t: polls){
            %>
            <table>
                <tr> <%=i++%> . <%=t.getHeading() %></tr> 
                <tr> <%= t.getDescription()%> </tr>
                <tr> <%= t.getOption1()%> </tr>
                <tr> <%= t.getOption2()%> </tr>
                <tr> <%= t.getOption3()%> </tr>
                <tr> <%= t.getOption4()%> </tr>
                <form action="/polling-participate" method="POST" >
                <label><%= t.getOption1()%></label><br>
                <input type="radio" name="option" value="1"><br>
                <label><%= t.getOption2()%></label><br>
                <input type="radio" name="option" value="2"><br>
                <label><%= t.getOption3()%></label><br>
                <input type="radio" name="option" value="3"><br>
                <label><%= t.getOption4()%></label><br>
                <input type="radio" name="option" value="4"><br>
                <button onclick="alert('Details Submitted')">Send poll option </button>
                </form>
                <tr>Date Created : <%= t.getDateCreated()%></tr>
                        
           </table>
             <br>
            <%  }}else{
            %>
            <h3>No polls to display</h3>
             <%}%>

        </body>
    </html>
