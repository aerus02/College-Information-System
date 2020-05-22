

<%@page import="com.softwareproject.collegeinformationsystem.model.Polling" %>
<%@page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Polling View</title>
        </head>
        <body>
            <h1>This is polling page</h1>
            
            <form action="/polling-create" method="POST" >
                        <input type="hidden" name="type" value="1" />
                        <button>Create Notice </button>
            </form>

                
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
                <tr>Date Created : <%= t.getDateCreated()%></tr>
                
                <tr><form action="polling-delete" method="POST" >
                       <input type="hidden" name="pollID" value="<%= t.getPollID()%>" />
                       <button onclick="alert('Poll will be deleted')">Delete</button>
                   </form></tr>
                   
           </table>
             <br>
            <%  }}else{
            %>
            <h3>No polls to display</h3>
             <%}%>

        </body>
    </html>
