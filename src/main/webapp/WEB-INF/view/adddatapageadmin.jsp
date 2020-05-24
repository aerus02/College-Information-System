
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <link href="css/adddatapagestyle.css" type="text/css" rel="stylesheet"><link/>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>CIS-Add Data</title>
        </head>
        <body>
           
            <div>Welcome,You are logged in as ${username}</div>
            
            <div>Student Data</div>
            
            <div>
            <form action="/add-data-student" method="POST" >
                <label for="stuName">Student Name</label>
                <input type="text"  name="stuName" ><br>
                <label for="stuID">Student ID</label>
                <input type="text"  name="stuID"><br>
                <label for="stuDOB">Date of Birth</label>
                <input type="text" placeholder="format:YYYY-MM-DD" name="stuDOB"><br>

                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            </div>
            
            
            <div>Faculty Data</div>
            
            <div>
            <form action="/add-data-faculty" method="POST" >
                <label for="facName">faculty Name</label>
                <input type="text"  name="facName" ><br>
                <label for="facID">Faculty ID</label>
                <input type="text"  name="facID"><br>
                <label for="facDOB">Date of Birth</label>
                <input type="text" placeholder="format:YYYY-MM-DD" name="facDOB"><br>

                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            </div>
            
            <div>Course Data</div>
            
            <form action="/add-data-course" method="POST" >
                <label for="couName">Course Name</label>
                <input type="text"  name="couName" ><br>
                <label for="collegeID">Course ID</label>
                <input type="text"  name="collegeID"><br>
                <label for="facCollegeID">Faculty ID</label>
                <input type="text"  name="facCollegeID"><br>

                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            
            <div>Course-TimeTable Data</div>
            
            <div>
            <form action="/add-data-timetable" method="POST" >
               
                
                <label for="couCollegeID">Course ID</label>
                <input type="text"  name="couCollegeID"><br>
                <label for="venue1">Venue1</label>
                <input type="text"  name="venue1" ><br>
                <label for="venue2">Venue2</label>
                <input type="text"  name="venue2" ><br>
                <label for="venue3">Venue3</label>
                <input type="text"  name="venue3" ><br>
                <label for="venue4">Venue4</label>
                <input type="text"  name="venue4" ><br>
                <label for="timings1">Time Slot1</label>
                <input type="text"  placholder="id between 1 to 45" name="timings1"><br>
                <label for="timings2">Time Slot2</label>
                <input type="text"  placholder="id between 1 to 45" name="timings2"><br>
                <label for="timings3">Time Slot3</label>
                <input type="text"  placholder="id between 1 to 45" name="timings3"><br>
                <label for="timings4">Time Slot4</label>
                <input type="text"  placholder="id between 1 to 45" name="timings4"><br>

                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            </div>
            
            <div>OtherLinks Data</div>
            
            <div>
            <form action="/add-data-otherlinks" method="POST" >
               <label for="url">URL</label>
                <input type="text"  name="url"><br>
                <label for="desc">Description</label>
                <input type="text"  name="desc" ><br>
               
                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            </div>
            
            <div>Course-StudentsList Data</div>
           <div>Add course ids and list of studentids enrolled in the course </div>
            <div>
            <form action="/add-data-attendance" method="POST" >
              
                <label for="couCollegeID">Course ID</label>
                <input type="text"  name="couCollegeID"><br>
                <label for="studentID1">Student ID 1</label>
                <input type="text"  name="studentID1" ><br>
                <label for="studentID2">Student ID 2</label>
                <input type="text"  name="studentID2" ><br>
                <label for="studentID3">Student ID 3</label>
                <input type="text"  name="studentID3" ><br>
                <label for="studentID4">Student ID 4</label>
                <input type="text"  name="studentID4" ><br>
                <label for="studentID5">Student ID 5</label>
                <input type="text"  name="studentID5" ><br>
                <label for="studentID6">Student ID 6</label>
                <input type="text"  name="studentID6" ><br>
                <label for="studentID7">Student ID 7</label>
                <input type="text"  name="studentID7" ><br>
                <label for="studentID8">Student ID 8</label>
                <input type="text"  name="studentID8" ><br>
                <label for="studentID9">Student ID 9</label>
                <input type="text"  name="studentID9" ><br>
                <label for="studentID10">Student ID 10</label>
                <input type="text"  name="studentID10" ><br>
                
                <button onclick="alert('Details Submitted')">Enter Data</button>
            </form>
            </div>
            
        </body>
    </html>
