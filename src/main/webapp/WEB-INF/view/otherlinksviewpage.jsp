

<%@page import="com.softwareproject.collegeinformationsystem.model.OtherLink" %>
<%@page import="java.util.List" %>





<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Otherlinks</title>
        </head>
        <body>
            <h1>This is otherlinksview page</h1>
            
               
            <table>
                <% 

                    int i = 1;
                    List<OtherLink> otherLinksList = (List<OtherLink>)request.getAttribute("othLin");

                %>
                <%
                    if(otherLinksList != null){
                    for(OtherLink t: otherLinksList){
                %>
                <tr>
                    <td> <%=i++%> </td> 
                    <td> <%= t.getDescription()%></td>
                    <td> <%= t.getUrl()%> </td>


                 </tr>
                <%  }
                    }
                    else{
                %>
                <h3>No data to display </h3>
                <%    }
                %>
            </table>

        </body>
    </html>
