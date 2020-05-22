
<%@page import="com.softwareproject.collegeinformationsystem.model.Notice" %>
<%@page import="java.util.List" %>




<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Notices</title>
        </head>
        <body>
            <h1>This is notices page</h1>
            
            Create Here
            <form action="/notices-create" method="POST" >
                        <input type="hidden" name="type" value="1" />
                        <button>Create Notice </button>
            </form>

                
            <% 
                int i = 1;
                List<Notice> notices = (List<Notice>)request.getAttribute("notices");
                //if possible,sort.
            %>
            <%
            if(notices != null){
            for(Notice t: notices){
            %>
            <table>
                <tr> <%=i++%> . <%=t.getHeading() %></tr> 
                <tr> <%= t.getDescription()%> </tr>
                <tr> <%= t.getCompleteDescription()%> </tr>
                <tr>Date Created : <%= t.getDateCreated()%></tr>
                   <tr><form action="/notices-delete" method="POST" >
                       <input type="hidden" name="noticeID" value="<%= t.getNoticeID()%>" />
                       <button onclick="alert('Notice will be deleted')">Delete</button>
                   </form></tr>
             </table>
             <br>
            <%  }}else{
            %>
            <h3>No notices to display</h3>
             <%}%>

        </body>
    </html>
