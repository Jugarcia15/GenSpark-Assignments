CREATE TABLE `student` (
  `student_ID` int NOT NULL AUTO_INCREMENT,
  `student_Name` varchar(45) NOT NULL,
  `student_Age` int NOT NULL,
  `student_course` varchar(45),
  PRIMARY KEY (`student_ID`)
);


insert into student (student_Name, student_Age, student_course, grade_Level)
values('Test', 18, 'IT',  12);
insert into student (student_Name, student_Age, student_course, grade_Level)
values('Sample', 18, 'Python',  12);
insert into student (student_Name, student_Age, student_course, grade_Level)
values('Example', 18, 'Advanced Python',  12);

drop table Student;

Alter table student add column grade_Level int;

select * from student;

insert into student (student_Name, student_Age, student_course)
values ('Juan', 17, 'Math');

insert into student (student_Name, student_Age, student_course)
values ('Johnny', 17, 'Java'),
	('Jimothy', 14, 'Spring'),
	('Stuart', 16, 'Physics'),
	('Rick', 14, 'Algebra'),
	('Smith', 15, 'History');
    
    SET SQL_SAFE_UPDATES=0;
    Update student
    set student_course='English'
    where student_Age = 17;
    SET SQL_SAFE_UPDATES=1;
    
    Update student
    set grade_level=12
    where student_Age = 17;
    
    insert into student (student_Name, student_Age, student_course)
values ('Johnny', 17, 'Java'),
		('Andrew', 18, 'Java'),
        ('Steph', 18, 'Java'),
        ('Andy', 17, 'Java'),
		('Jimothy', 14, 'Spring'),
        ('Jimbo', 15, 'Spring'),
        ('Marcellus', 13, 'Spring'),
        ('Marius', 14, 'Spring'),
		('Stuart', 16, 'Physics'),
        ('Little', 16, 'Physics'),
        ('Jackson', 16, 'Physics'),
        ('Michael', 17, 'Physics'),
		('Rick', 14, 'Algebra'),
        ('Ross', 14, 'Algebra'),
        ('Marshall', 15, 'Algebra'),
        ('Jaime', 14, 'Algebra'),
		('Smith', 15, 'History'),
        ('Jim', 15, 'History'),
        ('Bob', 16, 'History'),
        ('Big', 14, 'History'),
        ('Lucio', 15, 'History');
        
        select *, UPPER(student_Name) from student where student_course<> 'Spring';
        
        select student_ID, upper(student_Name), 
        student_Age *10, lower(student_course), 
        grade_Level 
        from student
        where student_course<> 'Spring';
    
		Update student
		set grade_level=11
		where student_Age = 17 AND student_ID = 7;
        
        
        Delete from student;
        select * from student;
        
        update student
        set student_ID=0, student_course='Core Java'
        where student_ID=28;
        
        show keys from student where key_name='PRIMARY';
		show keys from course where key_name='PRIMARY';
        
        select * from student;
        select * from course;
        
        alter table student
		add constraint fk_courseName
		foreign key(student_course) references course(course_name);
        
        alter table student
		drop foreign key fk_courseName;
        
        alter table student
		add constraint fk_courseName
		foreign key(student_course) references course(course_name)
		On delete cascade
		on update cascade;
        
        select * from student;