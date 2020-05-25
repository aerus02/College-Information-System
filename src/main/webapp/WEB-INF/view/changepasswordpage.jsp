



<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Change Password</title>
        </head>
        <body>
           
            <h1>This is the Change Password Page</h1>
            <div>Welcome,You are logged in as ${username}</div>
           
            <div>
                 <%
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires",0);
            response.setHeader("Pragma","no-cache");
            if(session.getAttribute("name") == null)
                response.sendRedirect("/home");
            %>
            <form action="/change-password" method="POST" >
                        <input type="hidden" name="submitCheck" value="1" />
                        
                        <label for="oldpass">Old Password</label>
                        <input type="password"  name="oldpass" ><br>
                        <label for="newpass">New Password</label>
                        <input type="password" placeholder="Atleast 6 characters"  name="newpass"><br>
                        <label for="renewpass">Re-Enter New Password</label>
                        <input type="password" name="renewpass"><br>
                        
                        
                        <button onclick="alert('Details Submitted')">Change password </button>
            </form>
            </div>
            
            
            <script>
                
                
            </script>
        </body>
    </html>
