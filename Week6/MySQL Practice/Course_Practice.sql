

CREATE TABLE `course` (
  `course_ID` int NOT NULL,
  `course_name` varchar(45),
  PRIMARY KEY (`course_name`)
);

insert into course values(1, 'Java'), (2, 'Spring'), (2, 'Physics'), (3, 'Algebra'), (4, 'History'), (5, 'Core Java');
insert into course values(6, 'IT Fundamentals');
insert into course values(8, 'Advanced IT');
insert into course values(7, 'IT Fundamentals 2');

insert into course values (10,'IT'), (11,'Python'), (12,'Advanced Python');
select * from course;

select student_ID, student_Name, course_ID, course_name
from student
inner join course
on student.student_course = course.course_name
where course_name<> 'Spring';

select student_ID, student_Name, course_ID,student_course, course_name
from student
left join course
on student.student_course = course.course_name;

select student_ID, student_Name, course_ID, student_course,course_name
from student
right join course
on student.student_course = course.course_name;

select * from student, course;

select student_ID, student_Name  from student 
where student_course='Core Java';

select student_ID, student_Name, student_Age, student_course
from student
order by student_Age desc;

select student_ID, student_Name, student_Age, student_course
from student
order by student_Age;

select student_ID, student_Name from student order by student_ID desc;

select * from student having student_course='Java';

select distinct student_course from student;

select distinct student_course, avg(student_Age) from student group by student_course;

select * from student;
select * from course;

update course
set course_ID=9
where course_name='Physics';