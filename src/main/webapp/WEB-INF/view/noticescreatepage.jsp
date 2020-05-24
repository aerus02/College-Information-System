


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Create Notice</title>
        </head>
        <body>
           
            <h1>This is the CreateNotice Page</h1>
            <div>Welcome,You are logged in as ${username}</div>
           
            <div>
            <form action="/notices-create" method="POST" >
                        <input type="hidden" name="type" value="2" />
                        
                        <label for="title">Title</label><br>
                        <input type="text"  name="title" ><br>
                        <label for="minidesc">Short Description</label><br>
                        <input type="text"  name="minidesc"><br>
                        <label for="compdesc">Complete Description</label><br>
                        <input type="text" maxlength="100" name="compdesc"><br>
                        <label for="courseID">Course ID</label><br>
                        <input type="text" name="courseID"><br>
                        
                        
                        <button onclick="alert('Details Submitted')">Create Notice </button>
            </form>
            </div>
            <div>Notice Form</div>
            
            
            <script>
                
                
            </script>
        </body>
    </html>
