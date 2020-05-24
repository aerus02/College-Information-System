
<%@page import="com.softwareproject.collegeinformationsystem.model.Course" %>
<%@page import="com.softwareproject.collegeinformationsystem.model.Student" %>
<%@page import="com.softwareproject.collegeinformationsystem.model.Attendance" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/attendanceviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Attendance Update</title>
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
                <div class="title">Attendance</div>
            <% 
                int i = 1;
                int courID = (int)request.getAttribute("courseID");
                List<Student> students = (List<Student>)request.getAttribute("studentsList");
                ArrayList<ArrayList<Integer> > attendance = (ArrayList<ArrayList<Integer> >)request.getAttribute("attendance");

                if(attendance != null){
            %>
            
             <table class="tab">
                 <% if((int)request.getAttribute("month") == 1){%>
                <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Student Name</th>
                <th class="table-cells2">Student ID</th>
                <th class="table-cells3">January</th>
                <th class="table-cells4">February</th>
                <th class="table-cells5">March</th>
                <th class="table-cells6">April</th>
                <th class="table-cells7">Update Attendance</th>

                </tr>
                
                <%}else{%>
                <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Student Name</th>
                <th class="table-cells2">Student ID</th>
                <th class="table-cells3">August</th>
                <th class="table-cells4">September</th>
                <th class="table-cells5">October</th>
                <th class="table-cells6">November</th>
                <th class="table-cells7">Update Attendance</th>
                </tr>
                <%}%>
            <%
            for(i = 0; i < attendance.size(); i+=1){
            %>
            <tr>
                <td class="index"> <%=i+1%> </td> 
                <td class="table-cells1"> <%= students.get(i).getName()%> </td>
                <td class="table-cells2"> <%= students.get(i).getCollegeID()%> </td>
                <td class="table-cells3"><%= attendance.get(i).get(0)%>  </td>
                <td class="table-cells4"> <%= attendance.get(i).get(1)%>  </td>
                <td class="table-cells5"> <%= attendance.get(i).get(2)%>  </td>
                <td class="table-cells6"> <%= attendance.get(i).get(3)%>  </td>
                <td class="table-cells6"> <button> Update</button></td>
             </tr>
             <tr>
             <form action="/attendance" method="POST">
                 <label><%=i+1%></label>
                 <label><%=students.get(i).getName()%></label>
                 <label><%=students.get(i).getCollegeID()%></label>
                 <input type="hidden" name="courseID" value="<%=courID%>"/>
                 <input type="hidden" name="updateReq" value="1"/>
                 <input  name="att1" value="<%= attendance.get(i).get(0)%>"/>
                 <input  name="att2" value="<%= attendance.get(i).get(1)%>"/>
                 <input  name="att3" value="<%= attendance.get(i).get(2)%>"/>
                 <input  name="att4" value="<%= attendance.get(i).get(3)%>"/>
                 <button class=".btn">Update</button>
             </form>

             </tr>
          <%  }
            %>
            
            </table>
            <!--<div class="desc">These are your course wise and month wise attendance percentages</div>-->
            <%}
            else{
            %>
            <div class="nildata">No attendance data to display </div>
            <% }%>
            </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>

        </body>
    </html>
