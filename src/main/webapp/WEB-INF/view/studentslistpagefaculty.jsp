
<%@page import="com.softwareproject.collegeinformationsystem.model.Student" %>
<%@page import="java.util.List" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Students List</title>
        </head>
        <body>
            <h1>This is students-list page</h1>
            
                
            <table>
            <% 
                int i = 1;
                List<Student> students = (List<Student>)request.getAttribute("studentsList");
                //if possible,sort.
            %>
            <%
            for(Student s: students){
            %>
            <tr>
                <!--set view course profile here-facName,strength,timetable-->
                <td> <%=i++%> </td> 
                <td> <%= s.getCollegeID()%> </td>
                <td> <%= s.getName()%> </td>
                <td>
                    <form action="/others-profile" method="POST" >
                        <input type="hidden" name="type" value=3 />
                        <input type="hidden" name="collegeID" value="<%=s.getCollegeID()%>" />
                        <button>View Profile </button>
                    </form>
                </td>
             </tr>
            <%  }
            %>
            </table>

        </body>
    </html>
