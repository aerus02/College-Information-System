
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="java.util.List" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-TimeTable</title>
        </head>
        <body>
            <h1>This is timeTable page</h1>
            

            <% 
            int i ,j;
            List<Course> courses = (List<Course>)request.getAttribute("courses");
            List<List<Integer> > timeTable = (List<List<Integer> >)request.getAttribute("timeTable");
         
            if(courses != null){
            %>
            <table>
            <%
            for(i = 0; i < 5; ++i){%>
            <tr>
            <%
                for(j = 0; j < 9; ++j){
            %>
            
                <%
                if(timeTable.get(i).get(j) == -1){%>
                <td> -</td>
                <%}
                else{
                %>
                <td> <%=courses.get(timeTable.get(i).get(j)).getCourseName() %></td>
                <%}
                %>
                
             
            <% }
            %>
            </tr>
            <%
               }
            %>
            </table>
            <%}
            else{
            %>
            <h3>No TimeTable to display </h3>
            <% }%>

        </body>
    </html>
