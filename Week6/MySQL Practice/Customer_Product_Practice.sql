
create database newtestdb;
use newtestdb;

/* Creating product table with constraints NOT NULL, CHECK, DEFAULT, UNIQUE, PK, AUTOINCREMENT	*/
/*  This needs to be created first since customer table is created with fk in definition.	*/
CREATE TABLE `product` (
  `product_ID` int NOT NULL UNIQUE AUTO_INCREMENT,
  `product_Name` varchar(45) NOT NULL,
  `product_Description` varchar(45) Default('Warning: May burn when on fire'),
  `product_Price` decimal(10,2) check(product_Price >=0),
  PRIMARY KEY (`product_ID`)
);

/* Display Primary Keys in table	*/
show keys from product where key_name='PRIMARY';

/* Creating customer table that references a productID from product table.	*/
/* ProductID is Not UNIQUE because multiple customers can have the same product.*/
/* This can be improved with a seperate ORDERS table, since customers can have many orders,*/
/* and orders can have many products.	*/
CREATE TABLE `customer` (
  `customer_ID` int UNIQUE NOT NULL AUTO_INCREMENT,
  `customer_Name` varchar(45) NOT NULL,
  `customer_Phone` varchar(20),
  `customer_Address` varchar(45) Default('123 Houston Ave'),
  `product_ID` int Not null,
  PRIMARY KEY (`customer_ID`),
  foreign key(product_ID) references product(product_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

/* Alternate way to add FK*/
/* First delete current FK, which can be found under Foreign Keys in Schema panel. */
alter table customer
drop foreign key customer_ibfk_1;

alter table customer
add constraint fk_productID
foreign key (product_ID) references product(product_ID)
On delete cascade
on update cascade;

/* Display Primary Keys in table	*/
show keys from customer where key_name='PRIMARY';

/* Insert into product table, product id is auto incremented. 	*/
insert into product (product_Name, product_Description, product_Price)
values ('Potato', 'A humble vegetable', 3.99),
('Strawberry', 'Deliciously red', 8.99),
('Banana', 'The Best Berry', 23.99),
('Personal Computer', 'Now with Windows 98', 999.99),
('Socks', 'Keeps your toes warm', 15.99),
('Tomato', 'A humble vegetable', 5.99); 

/* Retrieve all from product	*/
select * from product;

/* Insert into customer table, records, ID Is autoincremented	*/
insert into customer (customer_Name, customer_Phone, product_ID)
values('Jimothy','8322388323', 1),
('Johnathon','3563433131', 2),
('Xavier','7137137131', 4),
('Tonka','3462999999', 5),
('William','5555555555', 4),
('Juan','8323158468', 6);

/* Retrieve all from tables	*/
select * from product, customer;

/* COunting Product Names, and displaying in DESC order, since ASC default. 	*/
select product_Name, count(*) as 'Total'
from customer inner join product on customer.product_ID=product.product_ID
group by product.product_ID
order by count(*) desc;

/* retrieve records on inner joined tables, product price greater than 10.00 	*/
select customer_ID as 'ID', customer_Name as 'Name', product_name as 'Product Name', product_Price as 'Price'
from customer
inner join product
on customer.product_ID = product.product_ID
having product_Price>10;

/* Drop tables, just in case	*/
drop table product;
drop table customer;
