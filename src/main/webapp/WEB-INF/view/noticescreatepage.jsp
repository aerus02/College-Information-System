


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
           <link href="css/studentprofileviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Create Notice</title>
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
            <div >
                <div style="height:50px;"></div>
                <div class="title">Create Notice</div>
            

                
            <div style="width:70% ;margin : auto;background-color: white">
                
            <form action="/notices-create" method="POST" >
                <input type="hidden" name="type" value="2" />

                <label for="title">Title</label></br>
                <input class="noticecreate-input" type="text" placeholder="Enter Here" name="title" ><br>
                <label for="minidesc">Short Description</label><br>
                <input  class="noticecreate-input" type="text" placeholder="Enter Here"  name="minidesc"><br>
                <label for="compdesc">Complete Description</label><br>
                <input  class="noticecreate-input" type="text" placeholder="Enter Here" maxlength="100" name="compdesc"><br>
                <label for="courseID">Course ID</label><br>
                <input  class="noticecreate-input" type="text"placeholder="Enter Here"  name="courseID"><br>


                <button class="btn-notice-create" onclick="alert('Details Submitted')">Create Notice </button>
            </form>
            </div>
             </div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	
            
            
            
            
        </body>
    </html>
