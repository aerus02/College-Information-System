

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Registration Faculty</title>
            <style>
                *{
                    background-color: #87ff87;
                    font-family:sans-serif;
                    font-style: oblique;
                    margin : 0;
                    padding : 0;
                    border :0;
                }
                
                .div-data{
                    width:50%;
                    margin : auto;
                    background-color: #ffdf80;
                    font-size : 20px;
                }
                .btn{
                    border: none;
                    background-color: #ffdf80;
                    font-size: 20px;
                    cursor: pointer;
                }
                .btn:hover{
                    color : orange;
                }

            </style>
        </head>
        <body>
            <h1>Registration Page Faculty</h1>
            <div class="div-data">
                <form class="formSubmit" action="/register" method="POST">
                <input type="hidden"  name="pageType" value="2"/>
                <input type="hidden"  name="dataType" value="1"/>
                <label for="uname">Username</label>
                <input type="text" id="uname"  name="uname" /><br>
                <label for="password">Password</label>
                <input type="password" id="password"  name="password" /><br>
                <label for="repass">Re-Enter Password</label>
                <input type="password" id="repass"  name="repass" /><br>
                <label for="facname">Name</label>
                <input type="text" id="facname"  name="facname" /><br>
                <label for="facid">Faculty ID</label>
                <input type="text" id="facid" name="facid" /><br>
                <label for="facdob">Date of Birth</label>
                <input type="text" id="facdob" name="facdob" placeholder="Format : YYYY-MM-DD"/><br>
                <label for="facmailid">Mail ID</label>
                <input type="text" id="facmailid" name="facmailid" /><br>
                <label for="facphn">Phone Number</label>
                <input type="text" id="facphn" name="facphn" /><br>
                <label for="facgen">Gender</label>
                <input type="text" id="facgen" name="facgen" /><br>
                <label for="facdep">Department</label>
                <input type="text" id="facdep" name="facdep" /><br>
                <label for="facyoe">Date of Joining</label>
                <input type="text" id="facyoe" name="facyoe" placeholder="Format : YYYY-MM-DD" /><br>
                
                <button class="btn">Submit</button>
                
                </form>
            </div>
        </body>
    </html>
