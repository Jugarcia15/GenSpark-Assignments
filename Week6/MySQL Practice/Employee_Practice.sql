create database newtestdb;
use newtestdb;

create table employee (
	empid int NOT NULL,
    empname varchar(50) not null,
    empsalary double,
    location varchar(30)
);

select * from employee;

insert into employee
values ( 0, 'juan', 35000, 'houston');

insert into employee (empid, empname, location)
values (1, 'jimothy', 'webster');

insert into employee
values (2, 'johnathy', 25222, 'Spring' ),
		(3, 'jonah', 25252, 'Conroe');

insert into employee
values (4, 'selah', 25222, 'Spring' ),
		(5, 'donaldson', 25252, 'Conroe');
        
Alter table employee 
add designation varchar(50);

insert into employee(empid, empname, location)
values (6, 'selah', 'Spring' ),
		(7, 'donaldson', 'Conroe');

select * from employee;

alter table employee
drop column designation;

SET SQL_SAFE_UPDATES=0;
update employee
set designation='Sales Executive'
where empid='0';
SET SQL_SAFE_UPDATES=1;

SET SQL_SAFE_UPDATES=0;
update employee
set designation='Sales Executive', location='Chicago'
where empid=1;
SET SQL_SAFE_UPDATES=1;


select * from employee;

alter table employee
add deptID int;

select * from employee;

insert into employee(empid, empname, location)
values (1, 'selah', 'Spring' ),
		(2, 'donaldson', 'Conroe'),
        (3, 'Sonny', 'Spring' ),
		(4, 'Greg', 'Conroe'),
        (5, 'Tim', 'Spring' ),
		(6, 'Jim', 'Conroe'),
        (7, 'john', 'Spring' ),
		(8, 'donald', 'Conroe');
        
        update employee
        set deptID = 1
        where empid=1;
        update employee
        set deptID = 4
        where empid=4;
        update employee
        set deptID = 3
        where empid=3;
        update employee
        set deptID = 2
        where empid=2;
        update employee
        set deptID = 5
        where empid=5;
        update employee
        set deptID = 6
        where empid=6;
        update employee
        set deptID = 7
        where empid=7;
        update employee
        set deptID = 8
        where empid=8;
        
select * from employee;
select * from department;

update employee
set designation='HR'
where empid='4';
update employee
set designation='IT Support'
where empid='1';
update employee
set designation='Dev'
where empid='2';
update employee
set designation='Sales Executive'
where empid='3';
update employee
set designation='CEO'
where empid='4';
update employee
set designation='Sales Executive'
where empid='5';

create table department(
	deptID int not null,
    deptName varchar(25) not null
);

insert into department values(1, 'Java'), (2, 'Spring'), (2, 'Physics'), (3, 'Algebra'), (4, 'History'), (5, 'Core Java');


select empname, location, designation, deptName
from employee
inner join department
on employee.deptID = department.deptID;

Select * from employee;

select designation from employee group by designation;

select * from employee;

update employee
set empsalary=80000
where designation ='IT Support';

update employee
set empsalary=150000
where designation ='Sales Executive';

update employee
set empsalary=500000
where designation ='CEO';

update employee
set empsalary=120000
where designation ='Dev';


select * from employee;

select location, max(empsalary) as 'Maximum Salary'
from employee group by location;

select designation, sum(empsalary) as 'Total Salary'
from employee group by designation
having sum(empsalary)>100000;

alter table employee add primary key (empid);
alter table department add primary key (deptID);
select * from department;
update department
set deptID = 6
where deptName='Physics';
select * from department;

insert into department values (7,'Calculus'), (8, 'PreCalculus');

show keys from department where key_name='PRIMARY';
show keys from employee where key_name='PRIMARY';
show keys from employee where key_name='FOREIGN';

alter table employee
add constraint fk_deptId
foreign key(deptID) references department(deptID);

select * from employee;

alter table employee
drop foreign key fk_deptId;

alter table employee
add constraint fk_deptId
foreign key (deptID) references department(deptID)
On delete cascade
on update cascade;

