
<%@page import="com.softwareproject.collegeinformationsystem.model.Faculty" %>
<%@page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
             <link href="css/homepagestyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Faculty List</title>
            
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
            <header class="top1">Welcome,You are logged in as Admin</header>

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
                <div class="title">List of Faculty</div>
           
                
            <table class="tab">
             <tr>
                <th class="index">Index</th>
                <th class="table-cells1">Faculty Name</th>
                <th class="table-cells2">Faculty ID</th>
                <th class="table-cells3">Profile</th>
            </tr>
            <% 
                int i = 1;
                List<Faculty> faculties = (List<Faculty>)request.getAttribute("facultiesList");
                
            %>
            <%
            for(Faculty f: faculties){
            %>
            <tr>
                <!--set view course profile here-facName,strength,timetable-->
                <td class="index"> <%=i++%> </td> 
                <td class="table-cells1"> <%= f.getName()%> </td>
                <td class="table-cells2"> <%= f.getCollegeID()%> </td>
                
                <td class="table-cells3">
                    <form action="/others-profile" method="POST" >
                        <input type="hidden" name="type" value=2 />
                        <input type="hidden" name="collegeID" value="<%=f.getCollegeID()%>" />
                        <button class="btn">View Profile </button>
                    </form>
                </td>
             </tr>
            <%  }
            %>
            </table>
            </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>

        </body>
    </html>
