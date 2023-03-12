show databases;

use learnacadoms;

CREATE TABLE subjects
( 
	sub_name varchar(255) PRIMARY KEY 
);

INSERT INTO subjects
VALUES ('Hindi'),('Sanskrit'),('English'),('Mathematics'),('Environmental Studies'),('Science'),('Social Science'),('Chemistry'),('Physics'),('Biology'),('History'),('Geography'),('Political Science'),('Economics'),('Computer Science');
commit;--15

CREATE TABLE classes
( 
	id int PRIMARY KEY,
    class_name varchar(255) NOT NULL UNIQUE
);	

CREATE TABLE teachers
(
	id int PRIMARY KEY,
    teach_name varchar(255) NOT NULL UNIQUE
);

CREATE TABLE students
(
	id int PRIMARY KEY,
    stud_name varchar(255) NOT NULL,
    class_name varchar(255) NOT NULL
);

CREATE TABLE ClassCurriculum
(		
	class_name varchar(255) NOT NULL UNIQUE,
	subjects varchar(255) NOT NULL
);


CREATE TABLE TeacherSchedule
(		
	teach_name varchar(255) NOT NULL ,
	class_name varchar(255) NOT NULL,
	sub_name varchar (255) NOT NULL,
	CONSTRAINT UC_TeacherSchedule UNIQUE (class_name,sub_name)
);


INSERT INTO students values (1,'Prakhar Shrivastava','Class I');
INSERT INTO students values (2,'Rohit Sharma','Class I');
INSERT INTO students values (3,'Virat Kohli','Class II');
INSERT INTO students values (4,'Ravindra Jadeja','Class II');
INSERT INTO students values (5,'Ravichandran Ashwin','Class III');
INSERT INTO students values (6,'Shubman Gill','Class III');
INSERT INTO students values (7,'Cheteshwar Pujara','Class IV');
INSERT INTO students values (8,'Shreyas Iyer','Class IV');
INSERT INTO students values (9,'KL Rahul','Class V');
INSERT INTO students values (10,'KS Bharat','Class V');
INSERT INTO students values (11,'Axar Patel','Class VI');
INSERT INTO students values (12,'M Shami','Class VI');
INSERT INTO students values (13,'M Siraj','Class I');
INSERT INTO students values (14,'Umesh Yadav','Class II');