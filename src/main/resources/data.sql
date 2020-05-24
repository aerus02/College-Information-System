-- USE collegeinfo;
insert into users(userID,username,password) values(2,'ItsMe','Password');
insert into users(userID,username,password) values(4,'User1','Pass1');
insert into users(userID,username,password) values(1,'admin','@admin12');
insert into users(userID,username,password) values(3,'ranger','powers');
insert into users(userID,username,password) values(5,'hello','world');
insert into users(userID,username,password) values(6,'teach','onetwo');
insert into users(userID,username,password) values(7,'luffo','three');
insert into users(userID,username,password) values(8,'mach','green');
insert into users(userID,username,password) values(9,'helopa','mashit');

insert into admins(adminID,userID) values(1,1);

insert into students(studentID,studentname,userID,collegeID,YEAR_OF_ENROLLMENT) values(1,'stu1',2,'18cs10298',1092);
insert into students(studentID,studentname,userID,collegeID,YEAR_OF_ENROLLMENT) values(2,'stu2',3,'18me10204',2019);
insert into students(studentID,studentname,userID,collegeID,YEAR_OF_ENROLLMENT) values(3,'stu3',4,'19im30298',2008);
insert into students(studentID,studentname,userID,collegeID,YEAR_OF_ENROLLMENT) values(4,'stu4',5,'16ec10265',2018);


insert into faculties(facultyID,userID,collegeID) values(1,6,'cs102');
insert into faculties(facultyID,userID,collegeID) values(2,7,'ec145');
insert into faculties(facultyID,userID,collegeID) values(3,8,'ee307');
insert into faculties(facultyID,userID,collegeID) values(4,9,'im092');

-- 
-- insert into courses(courseID,COURSE_NAME,facultyID,strength) values(1,'DataStructures',1,10);
-- insert into courses(courseID,COURSE_NAME,facultyID,strength) values(2,'Sciences',3,20);
-- insert into courses(courseID,COURSE_NAME,facultyID,strength) values(3,'Algorithms',2,3);
-- insert into courses(courseID,COURSE_NAME,facultyID,strength) values(4,'Machines',4,6);


insert into courses(courseID,COURSENAME,facultyID,collegeID) values(1,'DataStructures',1,'cs1002');
insert into courses(courseID,COURSENAME,facultyID,collegeID) values(2,'Sciences',3,'py1003');


insert into attendances(studentID,courseID,attendanceID,value1,value2,value3,value4) values(1,2,1,1,3,2,1);
insert into attendances(studentID,courseID,attendanceID,value1,value2,value3,value4) values(1,1,2,2,2,2,2);
insert into attendances(studentID,courseID,attendanceID,value1,value2,value3,value4) values(4,1,3,2,3,5,4);
insert into attendances(studentID,courseID,attendanceID,value1,value2,value3,value4) values(2,2,4,5,4,3,24);


insert into timetables(TIMETABLEID,courseID,timings1,timings2,timings3,timings4) values(1,4,1,2,3,4);
insert into timetables(TIMETABLEID,courseID,timings1,timings2,timings3,timings4) values(2,3,1,2,3,-1);
insert into timetables(TIMETABLEID,courseID,timings1,timings2,timings3,timings4) values(3,2,5,7,-1,4);
insert into timetables(TIMETABLEID,courseID,timings1,timings2,timings3,timings4) values(4,1,21,5,6,9);


insert into otherlinks(otherlinkID,url,description) values(1,'url1','des1');
insert into otherlinks(otherlinkID,url,description) values(2,'url2','des2');
insert into otherlinks(otherlinkID,url,description) values(3,'url3','des3');
insert into otherlinks(otherlinkID,url,description) values(4,'url4','des4');
insert into otherlinks(otherlinkID,url,description) values(5,'url5','des5');
insert into otherlinks(otherlinkID,url,description) values(6,'url6','des6');
insert into otherlinks(otherlinkID,url,description) values(7,'url7','des7');
insert into otherlinks(otherlinkID,url,description) values(8,'url8','des8');

insert into pollings(pollID,description,count1,option1,courseID) values(1,'des1',1,'opt1',2);
insert into pollings(pollID,description,count1,option1,courseID) values(2,'des2',2,'opt12',3);
insert into pollings(pollID,description,count1,option1,courseID) values(3,'des7',21,'opt31',1);


insert into notices(noticeID,description,heading,courseID) values(1,'des1','heading1',2);
insert into notices(noticeID,description,heading,courseID) values(2,'des2','heading4',1);
insert into notices(noticeID,description,heading,courseID) values(3,'des3','heading7',1);
