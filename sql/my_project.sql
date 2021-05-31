--Product table
CREATE TABLE stock
(
product_id serial primary key,
brand_name varchar(20) not null,
product_name varchar(20) not null,
product_category varchar(20) not null,
arrival_date date not null,
initial_quantity int not null check (initial_quantity between 1 and 1000),
available_quantity int not null check (available_quantity between 1 and 1000),
rate int not null check ( rate between 1 and 1000000),
active bool not null default true
);
  
--user table
CREATE TABLE user_details
(
user_name varchar(10) primary key,
mobile_number bigint unique not null,
gender varchar(10) not null,
address varchar(50) not null,
email varchar(30) unique not null,
admin_user bool not null,
user_password varchar(20) not null
);

--Product
INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) 
values ('Boat','Rockerz 450','Headphone','2021-05-26',20,20,1400);

INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) 
values ('Samsung','Galaxy M31','Mobile','2021-05-26',30,30,15000);

INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) 
values ('Samsung','Galaxy F12','Mobile','2021-05-26',30,30,12000);

INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) 
values ('Apple','SE2020','Mobile','2021-05-27',20,20,40000);

INSERT INTO stock(brand_name,product_name,product_category,arrival_date,initial_quantity,available_quantity,rate ) 
values ('Dell','Inspiron 15','Laptop','2021-05-27',30,30,15000);

--User
INSERT INTO user_details(user_name,mobile_number,gender,address,email,admin_user,user_password ) values ('Admin',8888888888,'Male','Thoothukudi','Admin@gmail.com',true,'Admin@123')

--Display
SELECT * FROM stock;
SELECT * FROM user_details;

