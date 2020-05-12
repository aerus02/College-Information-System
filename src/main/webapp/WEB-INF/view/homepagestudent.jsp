

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Home</title>
        </head>
        <body>
           
             <!--response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");-->
           
            
            <h1>This is the Home Page - student</h1>
            <div>UserName :   ${username} </div>
            <div>Welcome,You are logged in as ${name}</div>
            <form action="/logout">
            <button>logout </button>
            </form>
            <form action="/change-password">
            <button>change password </button>
            </form>
            
            <div></div>  <!-- icon for menu bar  has Logout,change pass-->
            
            <form action="/polling-view">
            <button>Polling </button>
            </form>
            <div>Polling</div>
            
             <form action="/notices-view">
            <button>Notices</button>
            </form>
            <div>Notices</div>
            <form action="/profile">
            <button>Profile </button>
            </form>
            <div>Profile</div>	
            
            <form action="/attendance">
            <button>Attendance</button>
            </form>
            <div>Attendance</div>
            <form action="/courses-list">
            <button>Courses List </button>
            </form>
            <div>Courseslist</div>
            <form action="/faculties-list">
            <button>Faculty List</button>
            </form>
            <div>FacultyList</div>
            
           
            <br>
            <div>Messaging</div>
            <br>
            
            
            <form action="/timetable">
            <button>Timetable </button>
            </form>
            <div>TimeTable</div>
<!--            <form action="/others-profile">
            <button>Others Profile </button>
            </form>
            <div>Others Profile</div>-->
            <form action="/otherlinks">
            <button>other-links</button>
            </form>
            
            <div>OtherLinks</div>
            
        </body>
    </html>
