
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Registration</title>
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
            <h1>Registration Page</h1>
            <div class="div-data">
                <form class="formSubmit" action="/register" method="POST">
                <input type="hidden"  name="dataType" value="0"/>
                <input type="radio" id="student" name="pageType" value="1"/>
                <label for="student">Student</label><br>
                <input type="radio" id="faculty" name="pageType" value="2"/>
                <label for="faculty">Faculty</label><br>
                <button class="btn">Submit</button>
                
                </form>
            </div>
        </body>
    </html>
