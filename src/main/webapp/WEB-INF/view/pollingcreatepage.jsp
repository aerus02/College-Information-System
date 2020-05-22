
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-CreatePoll</title>
        </head>
        <body>
           
            <h1>This is the CreatePoll Page</h1>
            <div>Welcome,You are logged in as ${username}</div>
           
            <div>
            <form action="/polling-create" method="POST" >
                        <input type="hidden" name="type" value="2" />
                        
                        <label for="title">Title</label><br>
                        <input type="text"  name="title" ><br>
                        <label for="description">Description</label><br>
                        <input type="text" maxlength="40" name="description"><br>
                        <label for="courseID">Course ID</label><br>
                        <input type="text" name="courseID"><br>
                        <label for="option1">Option1</label><br>
                        <input type="text" name="option1" ><br>
                        <label for="option2">Option2</label><br>
                        <input type="text" name="option2" ><br>
                        <label for="option3">Option3</label><br>
                        <input type="text" name="option3" ><br>
                        <label for="option4">Option4</label><br>
                        <input type="text" name="option4" ><br>
                        
                        
                        <button onclick="alert('Details Submitted')">Create Poll </button>
            </form>
            </div>
            <div>Polling Form</div>
            
            
            <script>
                
                
            </script>
        </body>
    </html>
