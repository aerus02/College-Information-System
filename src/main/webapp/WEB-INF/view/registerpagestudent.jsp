
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Registration Student</title>
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
            <h1>Registration Page Student</h1>
            <div class="div-data">
                <form class="formSubmit" action="/register" method="POST">
                <input type="hidden"  name="pageType" value="1"/>
                <input type="hidden"  name="dataType" value="1"/>
                <label for="uname">Username</label>
                <input type="text" id="uname"  name="uname" /><br>
                <label for="password">Password</label>
                <input type="password" id="password"  name="password" /><br>
                <label for="repass">Re-Enter Password</label>
                <input type="password" id="repass"  name="repass" /><br>
                <label for="stuname">Name</label>
                <input type="text" id="stuname"  name="stuname" /><br>
                <label for="stuid">Student ID</label>
                <input type="text" id="stuid" name="stuid" /><br>
                <label for="studob">Date of Birth</label>
                <input type="text" id="studob" name="studob" placeholder="Format : YYYY-MM-DD"/><br>
                <label for="stumailid">Mail ID</label>
                <input type="text" id="stumailid" name="stumailid" /><br>
                <label for="stuphn">Phone Number</label>
                <input type="text" id="stuphn" name="stuphn" /><br>
                <label for="stugen">Gender</label>
                <input type="text" id="stugen" name="stugen" /><br>
                <label for="studep">Department</label>
                <input type="text" id="studep" name="studep" /><br>
                <label for="stuyoe">Year of Enrollment</label>
                <input type="text" id="stuyoe" name="stuyoe" /><br>
                <label for="stuenrolcou">Enrolled Course</label>
                <input type="text" id="stuenrolcou" name="stuenrolcou" /><br>
                
                <button class="btn">Submit</button>
                
                </form>
            </div>
        </body>
    </html>
