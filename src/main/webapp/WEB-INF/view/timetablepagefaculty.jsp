<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="java.util.List" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            
            <link href="css/homepagestyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-TimeTable</title>
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
                <div class="title">List of Courses</div>
             
                
            <% 
            int i ,j;
            List<Course> courses = (List<Course>)request.getAttribute("courses");
            List<List<Integer> > timeTable = (List<List<Integer> >)request.getAttribute("timeTable");

            if(courses != null){
            %>
           <table class="time-table">
                <tr>
                <th>Day</th>
                <th>8.00-9.00</th>
                <th >9.00-10.00</th>
                <th >10.00-11.00</th>
                <th>11.00-12.00</th>
                <th>12.00-13.00</th>
                <th>14.00-15.00</th>
                <th>15.00-16.00</th>
                <th>16.00-17.00</th>
                <th>17.00-18.00</th>
                
                </tr>
            <%
            for(i = 0; i < 5; ++i){%>
            <tr>
                <%switch(i){
                    case 0:%>
                    <td>Monday</td>
                   <% break;
                    case 1:%>
                    <td>Tuesday</td>
                  <%  break;
                    case 2:%>
                    <td>Wednesday</td>
                  <%  break;
                    case 3:%>
                    <td>Thursday</td>
                  <%  break;
                    case 4:%>
                    <td>Friday</td>
                  <%  break;
                    
                }%>
            <%
                for(j = 0; j < 9; ++j){
            %>
            
                <%
                if(timeTable.get(i).get(j) == -1){%>
                <td><p class="tt-elems">
                    -  
 
                    </p></td>
                <%}
                else{
                %>
                <td> <p class="tt-elems">
                        <%=courses.get(timeTable.get(i).get(j)).getCourseName() %>
                        
                    </p>
                <!--<p class="tt-elems"><%=courses.get(timeTable.get(i).get(j)).get %></p></td>-->
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
            <div class="nildata">No TimeTable to display </div>
            <% }%>
            
             </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	

        </body>
    </html>
