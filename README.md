
# College-Information-System
A web application for making institute information available faster and easier

##Table of Contents
*[Setup](##setup)
*[Technologies](##technologies)
*[Usage](##usage)
*[Login,Registration procedure](##login,registration-procedure)
*[Accessing Database](##accessing-database)
*[Features](##features)
*[Data to be filled by admin](##data-to-be-filled-by-admin)
*[Data to be filled by faculty](##data-to-be-filled-by-faculty)
*[Data to be filled by student](##data-to-be-filled-by-student)

##Setup
Download the collegeinformationsystem-0.0.1-SNAPSHOT.war file from [here](https://drive.google.com/open?id=1v8eFJjwbSGY027C-H5f3CgCXEZnPnLQt)
Run on command line 
'''
java -jar collegeinformationsystem-0.0.1-SNAPSHOT.war
'''
This will start application on localhost:8080

##Technologies
*Java 
*SpringBoot Framework
*HTML
*CSS
*Javascript
*JSP

##Usage
On running the jar or war file,go to localhost:8080/login.This displays 
a login page.Initially in database only admin credentials 
exist by default .
'''
Username - admin
Password - @admin12
'''

##Login,Registration Procedure
That means only admin can first login and even register functions 
won't work until database is partially populated by admin.
Admin on logging in reaches home page ,where AddData function will be present.
On entering AddData,few options will be displayed to populate database.

Student - StudentID,StudentName,StudentDateofBirth(YYYY-MM-DD Format) to be entered.
After admin enters data for student ,student users can register and these three
credentials will be used as verifiers for student's identity.

Similary for Faculty - FacultyID,FacultyName,FacultyDateOfBirth 
to be filled by admin first.
Faculty and Students will be able to register successfully upon vaild
details matching to those of admin entered ones.

Similarly admin enters valid course details in AddData for 
course,course-timetable,course-studentlist.
If entered details are invalid,redirecting to home page happens in addData fuction.

Only after all required valid details are entered into database by admin,all feaures 
like courseList,studentList,facultyList,TimeTable will work properly.

For notices,polls there is no such restriction,admin can create any time with 
valid courseID (Each poll or notice maps to a single courseID
but, multiple notices,polls can map to a single single course and vice versa.)

##Accessing Database
This Spring boot  application uses built-in h2 database for now and can be changed
to mysql later.
To access built-in in-memory h2 datatbase,
Go to localhost:8080/h2-cosole

It displays a form to connect to database to fill username and password,
leave them to be default as in code it is left so to be default, 
and click connect to access database.
Its' console looks more similar to mysql and database can be viewed ,edited,inspected here.
But problem with in-memory database is ,it loses data after program terminates.

Once student and faculty data are entered by admin,they can register and 
access their corresponding pages.
Messaging feature is left to be empty,all other features work properly.

##Features
*Notices
*CoursesList
*StudentsList
*Polling 
*Attendance
*FacultyList
*OtherLinks
*TimeTable...

##Data to be filled by admin
student - student id(string value),student name, student date of birth
faculty - faculty id(string value),faculty name,faculty date of birth
course - course id(string value),course name,faculty id
course timetable - 4 ints(between 1 to 45 denoting 45 slots in a week),
4 strings(room number for each slot)-fill all 4 entries ,even 
if course has only 2 or 3 slots,repeat some to fill.
course studentlist - at max 10 student ids each time to be filled(can be 0 as well)
For creating notices and polls - add data as to fill whole form

##Data to be filled by student
registration page - username,password should be of atleast 6 letters with chars 
or numbers,all the available data in form is to be filled properly and if asked ,
in given format. 
Same conditions apply for change password feature as well

##Data to be filled by faculty
registration page -same as student
attendance update - displays current percentage in percentage,if want to update,add 
on the same page with new percentage attendance per month for each student
avoid leading and tailing spaces.
