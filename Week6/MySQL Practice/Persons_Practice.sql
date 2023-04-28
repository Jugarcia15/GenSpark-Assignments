/* Constraints in my SQL*/

create table Persons(
personID int not null,
personName varchar(50) not null,
Age int check(Age>=18)
);

insert into Persons
values (0, 'Juan', 19),
		(1, 'Alex', 18);
        
        select * from Persons;
        
        Alter table Persons
        add primary key(personID);
        
        Alter table Persons
        drop primary key;
        
        
        