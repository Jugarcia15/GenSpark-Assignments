use newtestdb;

/* Jobs Table Creation */
create table jobs(
	job_ID int UNIQUE NOT NULL AUTO_INCREMENT,
    job_title varchar(45) not null,
    min_salary numeric check(min_salary > 0),
    max_salary numeric check(max_salary > 0),
primary key(job_ID)
);

/* Record Insertions */
insert into jobs (job_title, min_salary, max_salary)
values 
( 'Customer Service Advisor 2' , 25000, 40000),
( 'Customer Service Advisor 1' , 30000, 50000 ),
( 'Team Leader' , 60000 , 100000 ),
( 'Quality Assurance' , 80000 , 120000),
( 'Instructor' , 45000 , 90000);

/* Double check records in table */
select * from jobs;

/* Regions table creation */
create table regions(
	region_ID int not null AUTO_INCREMENT,
    region_Name varchar(45),
	primary key(region_id)
);

/* Record insertion */
insert into regions (region_Name)
values
('Americas'),
('Europe'),
('Asia'),
('Middle East'),
('Africa');

/* Double check records in table */
select * from regions;

/* creation of countries table */
create table countries(
	country_ID int not null AUTO_INCREMENT,
    country_Name varchar(45),
    region_ID int,
primary key(country_id),
foreign key (region_ID) references regions(region_ID)
);

/* insertion of records into countries table */
insert into countries (country_Name, region_ID)
values 
('United States' , 1),
('Mexico' , 1),
('France' , 2),
('Spain' , 2),
('China' , 3),
('Japan' , 3),
('Saudi Arabia' , 4),
('Iran' , 4),
('South Africa' , 5),
('Nigeria' , 5);

/* retrieve all records from countries table */
select * from countries;

/*  */
create table locations(
	location_ID int not null AUTO_INCREMENT,
    street_Address varchar(45),
    postal_Code varchar(25),
    city varchar(45) not null,
    state_Province varchar(25),
    country_ID int,
	primary key(location_id),
    foreign key (country_ID) references countries(country_ID)
);

/*  */
insert into locations (city, country_ID)
values
('Houston' , 1),
('New York' , 1),
('Mexico City' , 2),
('Kyoto' , 6),
('Paris' , 3);

/*  */
select * from locations;

/*  */
create table departments(
	department_ID int not null AUTO_INCREMENT,
    department_Name varchar(45) not null,
    manager_ID int,
    location_ID int,
	primary key(department_id),
    foreign key(location_ID) references locations(location_ID)
);

/*  */
insert into departments ( department_Name, location_ID)
values
('Administration' , 1),
('IT' , 2),
('Marketing' , 5),
('Benefits' , 3),
('Human Resources' , 4);

/*  */
select * from departments;

/*  */
CREATE TABLE employees (
  emp_ID int UNIQUE NOT NULL AUTO_INCREMENT,
  first_name varchar(45),
  last_name varchar(45) not null,
  email varchar(45) not null,
  phone_number varchar(20),
  hire_date date not null,
  job_id int not null,
  salary numeric check(salary > 0),
  commission_pct numeric(3,2),
  manager_ID int,
  department_ID int,
  PRIMARY KEY (emp_ID),
  foreign key(department_ID) references departments(department_ID),
  foreign key(job_id) references jobs(job_ID)
);

/*  */
drop table employees;
select * from employees;
/*  */
select * from jobs;

/*  */
insert into employees 
values 
(100, 'Stuart' , 'Stuart' , 'test1@gmail.com' ,'5555555555' ,  '2007-01-05' , 1, 125000 ,1 ,1,1),
(101, 'Rick' , 'Garcia' , 'test2@aol.com' , '5653139894' , '2008-12-12' , 2, 80000, 2,2,2),
(102, 'Sam' , 'Smith' , 'test3@hotmail.com' , '9496463132' , '2010-10-10' , 3, 90000,3 ,3,3),
(103, 'Ye' , 'Oda' , 'test4@outlook.com' , '8788586561' , '2015-12-01' , 4, 25000, 4,4,4),
(104, 'Stuart' , 'Little' , 'test5@live.com' , '1211211211' , '2016-06-30' , 5, 31250, 5,5,5);

/*  */
select * from employees;


/* First version of job_history */
create table job_history(
	employee_ID int not null,
    start_date date not null,
    end_date date not null,
    job_ID int not null,
    department_ID int,
primary key(start_date),
foreign key (employee_ID) references employees(emp_ID),
foreign key(job_ID) references jobs(job_ID),
foreign key(department_ID) references departments(department_ID)
);

/* Second version with composite key  */
create table job_history(
	employee_ID int not null,
    start_date date not null,
    end_date date not null,
    job_ID int not null,
    department_ID int not null /*,
 primary key(employee_ID, start_date),
foreign key (employee_ID) references employees(emp_ID),
foreign key(job_ID) references jobs(job_ID),
foreign key(department_ID) references departments(department_ID)
*/);

alter table job_history add unique index(
employee_ID,
start_date);

/* in case of mistake, drop table */
drop table job_history;

select * from job_history;

/* First version insertion */
insert into job_history (employee_ID, start_date, end_date, job_ID, department_ID)
values 
(6 , '2010-01-01' , '2020-01-31' , 2 , 2),
(7 , '2006-01-01' , '2020-12-31' , 1, 5),
(8 , '2007-06-01' , '2015-12-01' , 3, 3),
(9 , '2012-12-01' , '2018-12-31' , 4, 1),
(10 , '2015-12-01' , '2023-06-30' , 5, 4);

/*  */
select * from job_history;

/*  */
drop table locations, countries, regions, departments, employees, job_history, jobs;

create view employee_details_view as 
select employees.emp_ID,
employees.job_ID,
employees.manager_ID,
employees.department_ID,
departments.location_ID,
locations.country_ID,
employees.first_name,
employees.last_name,
employees.salary, 
employees.commission_pct,
departments.department_Name,
jobs.job_title,
locations.city,
locations.state_Province,
countries.country_Name,
regions.region_Name
from 
employees, departments, jobs, locations, countries, regions
 where
employees.department_ID = departments.department_ID and
departments.location_ID=locations.country_ID and
locations.country_ID=countries.country_ID and
countries.region_ID=regions.region_ID and
jobs.job_ID = employees.job_ID ;

/*
Write a SQL query to find the first name, last name, 
department, city, and state province for each employee 
*/
select 
employees.first_name,
employees.last_name,
departments.department_Name,
locations.state_Province
from 
employees, departments, locations
where
employees.department_ID = departments.department_ID and
departments.location_ID=locations.location_ID;

/*
Write a SQL query to find the first name, last name, salary, and job title for all employees. 
*/
select 
employees.first_name,
employees.last_name,
employees.salary, 
jobs.job_title
from
employees, jobs
where 
employees.job_ID=jobs.job_ID;

/*
Write a SQL query to find all those employees who work in department ID 20 or 10. 
Return first name, last name, department id and department name. 
There is no record.
*/
select 
employees.first_name,
employees.last_name,
employees.department_ID,
departments.department_Name
from 
employees, departments
where
employees.department_ID = departments.department_ID and
employees.department_ID = 10 and
employees.department_ID = 20;

/*
Adjusted previous for available record range.
*/
select 
employees.first_name,
employees.last_name,
employees.department_ID,
departments.department_Name
from 
employees, departments
where
employees.department_ID = departments.department_ID and
employees.department_ID = 1 or
employees.department_ID = 5;

select * from employees;

drop view employee_details_view;
select * from employee_details_view ;
