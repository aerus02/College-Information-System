
<%@page import="com.softwareproject.collegeinformationsystem.model.Faculty" %>
<%@page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Faculty List</title>
        </head>
        <body>
            <h1>This is faculties-list page</h1>
           
                
            <table>
            <% 
                int i = 1;
                List<Faculty> faculties = (List<Faculty>)request.getAttribute("facultiesList");
                //if possible,sort.
            %>
            <%
            for(Faculty f: faculties){
            %>
            <tr>
                <!--set view course profile here-facName,strength,timetable-->
                <td> <%=i++%> </td> 
                <td> <%= f.getCollegeID()%> </td>
                <td> <%= f.getName()%> </td>
                <td>
                    <form action="/others-profile" method="POST" >
                        <input type="hidden" name="type" value=2 />
                        <input type="hidden" name="collegeID" value="<%=f.getCollegeID()%>" />
                        <button>View Profile </button>
                    </form>
                </td>
             </tr>
            <%  }
            %>
            </table>

        </body>
    </html>
