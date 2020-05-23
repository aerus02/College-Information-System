
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Home</title>
            <style>
                *{
                        background-color: #87ff87;
                        font-family:sans-serif;
                        font-style: oblique;
                        margin : 0;
                        padding : 0;
                        border :0;
                }

                .top1{
                        background-color: #ff4d4d;
                        color: white;
                        padding : 18px 0px;
                        padding-left: 10px;
                        font-size:24px;
                }

                .top2{
                        background-color:black;
                }

                .top2 ul{
                        list-style: none;
                        padding:10px 0px;
                        background-color:black;
                }

                .top2 li{
                        display:inline;
                        background-color:black;
                        padding-left: 10px;
                        padding-right: 10px;
                }

                .top2 a{
                        color : #fff;
                        text-decoration: none;
                        font-size : 18px;
                        padding:0px 15px;
                        background-color:transparent !important;
                }

                .top2 a:hover{
                        color: orange;
                }


                .middle{
                        height:670px;
                }

                .items{
                        font-size: 20px;
                        padding-top :10px ;
                        padding-bottom: 10px;
                        margin:auto;
                        text-align: center;
                }

                .blocks a:hover{
                        color : red;
                }

                .blocks{
                        width:80%;
                        background-color: #ffdf80;
                        margin : auto;
                        padding-top: 10px;
                        padding-bottom :10px;
                        border: 3px solid blue;
                }

                .middle a{
                        color : black;
                        text-decoration: none;
                    background-color:transparent !important;
                }

                .bottom{
                       text-align : left;
                        background-color: black;
                        color : white;
                        font-size: 14px;
                        padding : 5px 10px;
                }
                
            </style>
        </head>
        <body>
            
            <header class="top1">Welcome,You are logged in as ${name}</header>

            <nav class="top2">
            	<div id="nav-bar-div">
            		<ul>
            			<li><a href="/logout">Logout</a></li>
            			<li><a href="/change-password">change password</a></li>
            		</ul>
            	</div>

            </nav>
            <div class="middle">

            <div class="items" ><div class="blocks"><a href="/polling-view">Polling</a></div></div>
        	
            
            <div class="items"><div class="blocks"><a href="/notices-view">Notices</a></div></div>
        	
            <div class="items"><div class="blocks"><a href="/profile">Profile</a></div></div>	
            
            <div class="items"><div class="blocks"><a href="/attendance">Attendance</div></div>
            <div class="items"><div class="blocks"><a href="/courses-list">Courses List</a></div></div>
            <div class="items"><div class="blocks"><a href="/faculties-list">Faculty List</a></div></div>
            
           
            <div class="items"><div class="blocks"><a href="/#">Messaging</a></div></div>
            
            <div class="items"><div class="blocks"><a href="/timetable">TimeTable</a></div></div>

            <div class="items"><div class="blocks"><a href="/otherlinks">Other Links</a></div></div>
            
       		</div>
            <footer class="bottom">college information system</footer>	
            
            
        </body>
    </html>
