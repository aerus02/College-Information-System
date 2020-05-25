
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
             <link href="css/pollingviewstyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Create Poll</title>
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
                <div class="title">Create Poll</div>
                        <div style="width:70% ;margin : auto;background-color: white">


            <div>
            <form action="/polling-create" method="POST" >
                        <input type="hidden" name="type" value="2" />
                        
                        <label for="title">Title</label><br>
                        <input type="text" class="pollingcreateinputs" name="title" placeholder="Enter Here"><br>
                        <label for="description">Description</label><br>
                        <!--<input type="text" maxlength="40" placeholder="Enter Here" name="description"><br>-->
                        <input type="text" class="pollingcreateinputs" placeholder="Enter Here" name="description"><br>

                        <label for="courseID">Course ID</label><br>
                        <input type="text"class="pollingcreateinputs"  name="courseID" placeholder="Enter Here"><br>
                        <label for="option1">Option1</label><br>
                        <input type="text" class="pollingcreateinputs"  name="option1" placeholder="Enter Here"><br>
                        <label for="option2">Option2</label><br>
                        <input type="text"class="pollingcreateinputs" name="option2" placeholder="Enter Here"><br>
                        <label for="option3">Option3</label><br>
                        <input type="text"class="pollingcreateinputs" name="option3" placeholder="Enter Here"><br>
                        <label for="option4">Option4</label><br>
                        <input type="text" class="pollingcreateinputs" name="option4" placeholder="Enter Here"><br>
                        
                        
                        <button onclick="alert('Details Submitted')">Create Poll </button>
            </form>
            </div>
                        </div></div>
            <div style="height:50px;"></div>
            <footer class="bottom">college information system</footer>	
            
            
        </body>
    </html>
