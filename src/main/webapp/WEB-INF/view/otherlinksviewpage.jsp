

<%@page import="com.softwareproject.collegeinformationsystem.model.OtherLink" %>
<%@page import="java.util.List" %>





<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/homepagestyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Other Links</title>
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
             <table class="tab">
                <tr>
                <th class="othLi-1">Title</th>
                <th class="othLi-2">URL</th>
                </tr>
                <% 

                    List<OtherLink> otherLinksList = (List<OtherLink>)request.getAttribute("othLin");

                %>
                <%
                    if(otherLinksList != null){
                    for(OtherLink t: otherLinksList){
                %>
                <tr>
                    <td class="othLi-1"> <%= t.getDescription()%></td>
                    <td class="othLi-2"> <a class="othLi-a" href="<%= t.getUrl()%>" ><%= t.getUrl()%></a> </td>


                 </tr>
                <%  }
                    }
                    else{
                %>
                <div class="nildata">No data to display </div>
                <%    }
                %>
            </table>
            </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	
        </body>
    </html>
