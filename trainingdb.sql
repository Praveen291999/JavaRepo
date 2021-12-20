select database();
use trainingdb;
create table offices(
 `officeCode` varchar(10) NOT NULL,
  `city` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `addressLine1` varchar(50) NOT NULL,
  `addressLine2` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `postalCode` varchar(15) NOT NULL,
  `territory` varchar(10) NOT NULL,
  PRIMARY KEY (`officeCode`)
  );
 
 create table employees(
   `employeeNumber` int(11) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `extension` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `officeCode` varchar(10) NOT NULL,
  `reportsTo` int(11) DEFAULT NULL,
  `jobTitle` varchar(50) NOT NULL,
  PRIMARY KEY (`employeeNumber`),
  KEY `reportsTo` (`reportsTo`),
  KEY `officeCode` (`officeCode`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`reportsTo`) REFERENCES `employees` (`employeeNumber`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`officeCode`) REFERENCES `offices` (`officeCode`)
);

create table customers(
`customerNumber` int(11) NOT NULL,
  `customerName` varchar(50) NOT NULL,
  `contactLastName` varchar(50) NOT NULL,
  `contactFirstName` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `addressLine1` varchar(50) NOT NULL,
  `addressLine2` varchar(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) DEFAULT NULL,
  `postalCode` varchar(15) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `salesRepEmployeeNumber` int(11) DEFAULT NULL,
  `creditLimit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`customerNumber`),
  KEY `salesRepEmployeeNumber` (`salesRepEmployeeNumber`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`salesRepEmployeeNumber`) REFERENCES `employees` (`employeeNumber`)
  );
  
  create table payments(
 `customerNumber` int(11) NOT NULL,
  `checkNumber` varchar(50) NOT NULL,
  `paymentDate` date NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`customerNumber`,`checkNumber`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
);

create table productlines(
  `productLine` varchar(50) NOT NULL,
  `textDescription` varchar(4000) DEFAULT NULL,
  `htmlDescription` mediumtext,
  `image` mediumblob,
  PRIMARY KEY (`productLine`)
  );
  
  create table products(
`productCode` varchar(15) NOT NULL,
  `productName` varchar(70) NOT NULL,
  `productLine` varchar(50) NOT NULL,
  `productScale` varchar(10) NOT NULL,
  `productVendor` varchar(50) NOT NULL,
  `productDescription` text NOT NULL,
  `quantityInStock` smallint(6) NOT NULL,
  `buyPrice` decimal(10,2) NOT NULL,
  `MRP` decimal(10,2) NOT NULL,
  PRIMARY KEY (`productCode`),
  KEY `productLine` (`productLine`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`productLine`) REFERENCES `productlines` (`productLine`)
);
create table orders(
  `orderNumber` int(11) NOT NULL,
  `orderDate` date NOT NULL,
  `requiredDate` date NOT NULL,
  `shippedDate` date DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `comments` text,
  `customerNumber` int(11) NOT NULL,
  PRIMARY KEY (`orderNumber`),
  KEY `customerNumber` (`customerNumber`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
);
create table orderdetails(
`orderNumber` int(11) NOT NULL,
  `productCode` varchar(15) NOT NULL,
  `quantityOrdered` int(11) NOT NULL,
  `priceEach` decimal(10,2) NOT NULL,
  `orderLineNumber` smallint(6) NOT NULL,
  PRIMARY KEY (`orderNumber`,`productCode`),
  KEY `productCode` (`productCode`),
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`orderNumber`) REFERENCES `orders` (`orderNumber`),
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`productCode`) REFERENCES `products` (`productCode`)
  );
  
  insert  into `offices`(`officeCode`,`city`,`phone`,`addressLine1`,`addressLine2`,`state`,`country`,`postalCode`,`territory`) values 

('1','San Francisco','+1 650 219 4782','100 Market Street','Suite 300','CA','USA','94080','NA'),

('2','Boston','+1 215 837 0825','1550 Court Place','Suite 102','MA','USA','02107','NA'),

('3','NYC','+1 212 555 3000','523 East 53rd Street','apt. 5A','NY','USA','10022','NA'),

('4','Paris','+33 14 723 4404','43 Rue Jouffroy D\'abbans',NULL,NULL,'France','75017','EMEA'),

('5','Tokyo','+81 33 224 5000','4-1 Kioicho',NULL,'Chiyoda-Ku','Japan','102-8578','Japan'),

('6','Sydney','+61 2 9264 2451','5-11 Wentworth Avenue','Floor #2',NULL,'Australia','NSW 2010','APAC'),

('7','London','+44 20 7877 2041','25 Old Broad Street','Level 7',NULL,'UK','EC2N 1HN','EMEA');

insert  into `employees`(`employeeNumber`,`lastName`,`firstName`,`extension`,`email`,`officeCode`,`reportsTo`,`jobTitle`) values 

(1002,'Murphy','Diane','x5800','dmurphy@classicmodelcars.com','1',NULL,'President'),

(1056,'Patterson','Mary','x4611','mpatterso@classicmodelcars.com','1',1002,'VP Sales'),

(1076,'Firrelli','Jeff','x9273','jfirrelli@classicmodelcars.com','1',1002,'VP Marketing'),

(1088,'Patterson','William','x4871','wpatterson@classicmodelcars.com','6',1056,'Sales Manager (APAC)'),

(1102,'Bondur','Gerard','x5408','gbondur@classicmodelcars.com','4',1056,'Sale Manager (EMEA)'),

(1143,'Bow','Anthony','x5428','abow@classicmodelcars.com','1',1056,'Sales Manager (NA)'),

(1165,'Jennings','Leslie','x3291','ljennings@classicmodelcars.com','1',1143,'Sales Rep'),

(1166,'Thompson','Leslie','x4065','lthompson@classicmodelcars.com','1',1143,'Sales Rep'),

(1188,'Firrelli','Julie','x2173','jfirrelli@classicmodelcars.com','2',1143,'Sales Rep'),

(1216,'Patterson','Steve','x4334','spatterson@classicmodelcars.com','2',1143,'Sales Rep'),

(1286,'Tseng','Foon Yue','x2248','ftseng@classicmodelcars.com','3',1143,'Sales Rep'),

(1323,'Vanauf','George','x4102','gvanauf@classicmodelcars.com','3',1143,'Sales Rep'),

(1337,'Bondur','Loui','x6493','lbondur@classicmodelcars.com','4',1102,'Sales Rep'),

(1370,'Hernandez','Gerard','x2028','ghernande@classicmodelcars.com','4',1102,'Sales Rep'),

(1401,'Castillo','Pamela','x2759','pcastillo@classicmodelcars.com','4',1102,'Sales Rep'),

(1501,'Bott','Larry','x2311','lbott@classicmodelcars.com','7',1102,'Sales Rep'),

(1504,'Jones','Barry','x102','bjones@classicmodelcars.com','7',1102,'Sales Rep'),

(1611,'Fixter','Andy','x101','afixter@classicmodelcars.com','6',1088,'Sales Rep'),

(1612,'Marsh','Peter','x102','pmarsh@classicmodelcars.com','6',1088,'Sales Rep'),

(1619,'King','Tom','x103','tking@classicmodelcars.com','6',1088,'Sales Rep'),

(1621,'Nishi','Mami','x101','mnishi@classicmodelcars.com','5',1056,'Sales Rep'),

(1625,'Kato','Yoshimi','x102','ykato@classicmodelcars.com','5',1621,'Sales Rep'),

(1702,'Gerard','Martin','x2312','mgerard@classicmodelcars.com','4',1102,'Sales Rep');

insert  into `customers`(`customerNumber`,`customerName`,`contactLastName`,`contactFirstName`,`phone`,`addressLine1`,`addressLine2`,`city`,`state`,`postalCode`,`country`,`salesRepEmployeeNumber`,`creditLimit`) values 

(103,'Atelier graphique','Schmitt','Carine ','40.32.2555','54, rue Royale',NULL,'Nantes',NULL,'44000','France',1370,'21000.00'),

(112,'Signal Gift Stores','King','Jean','7025551838','8489 Strong St.',NULL,'Las Vegas','NV','83030','USA',1166,'71800.00'),

(114,'Australian Collectors, Co.','Ferguson','Peter','03 9520 4555','636 St Kilda Road','Level 3','Melbourne','Victoria','3004','Australia',1611,'117300.00'),

(119,'La Rochelle Gifts','Labrune','Janine ','40.67.8555','67, rue des Cinquante Otages',NULL,'Nantes',NULL,'44000','France',1370,'118200.00'),

(496,'Kelly\'s Gift Shop','Snowden','Tony','+64 9 5555500','Arenales 1938 3\'A\'',NULL,'Auckland  ',NULL,NULL,'New Zealand',1612,'110000.00');

insert  into `orders`(`orderNumber`,`orderDate`,`requiredDate`,`shippedDate`,`status`,`comments`,`customerNumber`) values 

(10100,'2003-01-06','2003-01-13','2003-01-10','Shipped',NULL,103),

(10101,'2003-01-09','2003-01-18','2003-01-11','Shipped','Check on availability.',112),

(10102,'2003-01-10','2003-01-18','2003-01-14','Shipped',NULL,114),

(10103,'2003-01-29','2003-02-07','2003-02-02','Shipped',NULL,119),

(10105,'2003-02-11','2003-02-21','2003-02-12','Shipped',NULL,496);

insert  into `payments`(`customerNumber`,`checkNumber`,`paymentDate`,`amount`) values 

(103,'HQ336336','2004-10-19','6066.78'),

(103,'JM555205','2003-06-05','14571.44'),

(103,'OM314933','2004-12-18','1676.14'),

(112,'BO864823','2004-12-17','14191.12'),

(112,'HQ55022','2003-06-06','32641.98'),

(112,'ND748579','2004-08-20','33347.88'),

(114,'GG31455','2003-05-20','45864.03'),

(114,'MA765515','2004-12-15','82261.22'),

(114,'NP603840','2003-05-31','7565.08'),

(114,'NR27552','2004-03-10','44894.74'),

(496,'MN89921','2004-12-31','52166.00');

insert  into `productlines`(`productLine`,`textDescription`,`htmlDescription`,`image`) values 

('Classic Cars','Attention car enthusiasts: Make your wildest car ownership dreams come true. Whether you are looking for classic muscle cars, dream sports cars or movie-inspired miniatures, you will find great choices in this category. These replicas feature superb attention to detail and craftsmanship and offer features such as working steering system, opening forward compartment, opening rear trunk with removable spare wheel, 4-wheel independent spring suspension, and so on. The models range in size from 1:10 to 1:24 scale and include numerous limited edition and several out-of-production vehicles. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.',NULL,NULL),

('Motorcycles','Our motorcycles are state of the art replicas of classic as well as contemporary motorcycle legends such as Harley Davidson, Ducati and Vespa. Models contain stunning details such as official logos, rotating wheels, working kickstand, front suspension, gear-shift lever, footbrake lever, and drive chain. Materials used include diecast and plastic. The models range in size from 1:10 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. All models come fully assembled and ready for display in the home or office. Most include a certificate of authenticity.',NULL,NULL),

('Planes','Unique, diecast airplane and helicopter replicas suitable for collections, as well as home, office or classroom decorations. Models contain stunning details such as official logos and insignias, rotating jet engines and propellers, retractable wheels, and so on. Most come fully assembled and with a certificate of authenticity from their manufacturers.',NULL,NULL),

('Ships','The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.',NULL,NULL),

('Trains','Model trains are a rewarding hobby for enthusiasts of all ages. Whether you\'re looking for collectible wooden trains, electric streetcars or locomotives, you\'ll find a number of great choices for any budget within this category. The interactive aspect of trains makes toy trains perfect for young children. The wooden train sets are ideal for children under the age of 5.',NULL,NULL),

('Trucks and Buses','The Truck and Bus models are realistic replicas of buses and specialized trucks produced from the early 1920s to present. The models range in size from 1:12 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. Materials used include tin, diecast and plastic. All models include a certificate of authenticity from their manufacturers and are a perfect ornament for the home and office.',NULL,NULL),

('Vintage Cars','Our Vintage Car models realistically portray automobiles produced from the early 1900s through the 1940s. Materials used include Bakelite, diecast, plastic and wood. Most of the replicas are in the 1:18 and 1:24 scale sizes, which provide the optimum in detail and accuracy. Prices range from $30.00 up to $180.00 for some special limited edition replicas. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.',NULL,NULL);

insert  into `products`(`productCode`,`productName`,`productLine`,`productScale`,`productVendor`,`productDescription`,`quantityInStock`,`buyPrice`,`MRP`) values 

('S10_1678','1969 Harley Davidson Ultimate Chopper','Motorcycles','1:10','Min Lin Diecast','This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.',7933,'48.81','95.70'),

('S10_1949','1952 Alpine Renault 1300','Classic Cars','1:10','Classic Metal Creations','Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',7305,'98.58','214.30'),

('S10_2016','1996 Moto Guzzi 1100i','Motorcycles','1:10','Highway 66 Mini Classics','Official Moto Guzzi logos and insignias, saddle bags located on side of motorcycle, detailed engine, working steering, working suspension, two leather seats, luggage rack, dual exhaust pipes, small saddle bag located on handle bars, two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand, diecast metal with plastic parts and baked enamel finish.',6625,'68.99','118.94'),

('S10_4698','2003 Harley-Davidson Eagle Drag Bike','Motorcycles','1:10','Red Start Diecast','Model features, official Harley Davidson logos and insignias, detachable rear wheelie bar, heavy diecast metal with resin parts, authentic multi-color tampo-printed graphics, separate engine drive belts, free-turning front fork, rotating tires and rear racing slick, certificate of authenticity, detailed engine, display stand\r\n, precision diecast replica, baked enamel finish, 1:10 scale model, removable fender, seat and tank cover piece for displaying the superior detail of the v-twin engine',5582,'91.02','193.66'),

('S10_4757','1972 Alfa Romeo GTA','Classic Cars','1:10','Motor City Art Classics','Features include: Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',3252,'85.68','136.00'),

('S10_4962','1962 LanciaA Delta 16V','Classic Cars','1:10','Second Gear Diecast','Features include: Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',6791,'103.42','147.74'),

('S12_1099','1968 Ford Mustang','Classic Cars','1:12','Autoart Studio Design','Hood, doors and trunk all open to reveal highly detailed interior features. Steering wheel actually turns the front wheels. Color dark green.',68,'95.34','194.57'),

('S12_1108','2001 Ferrari Enzo','Classic Cars','1:12','Second Gear Diecast','Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',3619,'95.59','207.80'),

('S72_3212','Pont Yacht','Ships','1:72','Unimax Art Galleries','Measures 38 inches Long x 33 3/4 inches High. Includes a stand.\r\nMany extras including rigging, long boats, pilot house, anchors, etc. Comes with 2 masts, all square-rigged',414,'33.30','54.60');


insert  into `orderdetails`(`orderNumber`,`productCode`,`quantityOrdered`,`priceEach`,`orderLineNumber`) values 

(10100,'S10_1678',30,'136.00',3),

(10100,'S10_1949',50,'55.09',2),

(10100,'S10_2016',22,'75.46',4),

(10100,'S10_4698',49,'35.29',1),

(10101,'S10_4757',25,'108.06',4),

(10101,'S10_4962',26,'167.06',1),

(10101,'S12_1099',45,'32.53',3),

(10101,'S12_1108',46,'44.35',2),

(10102,'S72_3212',39,'95.55',2);

select database();

use trainingdb;
CREATE TABLE emp1(
empno INT AUTO_INCREMENT primary key,
firstname varchar(30),
lastname varchar(30)
);

insert into emp1 (firstname,lastname)
values('john','dave'),
	  ('jam','kam');
      

delete from emp1 where empno=2;
select * from emp1;

insert into emp1 (firstname,lastname)
values('john','dave'),
	  ('jam','kam');
select * from emp1;

update emp1

set
firstname='cam',
empno=5
where
empno=3;

select * from emp1;
commit;

CREATE TABLE vehicle (
  vehicleid int,
  year int not null,
  make varchar(100) not null,
  primary key(vehicleid)
  );
  
  alter table vehicle
  add model varchar(20) not null;
  
  select * from vehicle;
  
  alter table vehicle
  add purc varchar(20) not null
  after make;
  
  modifying the column
  
  alter table vehicle
  modify purc varchar(100) not null
  after make;
  
  change column name
  
  alter table vehicle
   change column purc Dateofpurchase varchar(100) not null;
   
   
   for dropping the column
   
   alter table vehicle 
   drop column note;
   
     select * from vehicle;
     
     rename the table
     
     alter table vehicle 
     rename to car;
         
         select * from car;
     
  CREATE TABLE Persons (
    PersonID int auto_increment,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);
select * from Persons;


alter table Persons
add age int not null;

alter table Persons
add dob Date not null
after PersonID;


check constraint
create table cart(
	item_id int auto_increment primary key,
    name varchar(100) not null,
    quantity int not null,
    price dec(5,2) not null,
    sales_tax dec(5,2) not null default 0.1,
    CHECK (quantity>0),
    CHECK (sales_tax>=0)
    );
    
    insert into cart(name,quantity,price,sales_tax)values
    ('jn',4,8,1.1);
    select * from cart;
    
    set default value for default;;
    
    alter table cart
    alter column quantity set default 10;
     insert into cart(name,price)values
    ('kn',6);
       
       select * from cart;
       
       drop the default from table:::
       alter table tablename
       alter column column_name  drop default
       
       Drop a table:::  drop table table_name
       
       select customerName,city,state          ::to get particular columns
       FROM customers;
       
       select 1+1 as sum;              ::::::create temporary table
		
        select now();           to display current date andtime
       
       String concatenation::
        select concat('jon','sam')as name;  
        
        
        Sorting:: using order by ascending
        
        select 
			firstname,                 
            lastname
		From 
			employees
		order by 
             firstname;
             
  IN descending order:::           
              select 
			firstname,
            lastname
		From 
			employees
		order by 
             firstname desc;
             
             select * from orderdetails
             
             We can perform operations on the colums::
             
select 
ordernumber,
orderlinenumber,
quantityordered*priceEach
from
orderdetails
order by
quantityordered*priceeach desc;

where condition AND,OR ,NOT,like,between,regex,in,is null,is not null

select 
firstname,lastname,jobtitle
from 
employees
where
jobtitle='sales rep'
order by
firstname asc;

And in where

select 
firstname,lastname,jobtitle,officecode
from 
employees
where
jobtitle='sales rep' and officecode=1;

OR in where:

select 
firstname,lastname,jobtitle,officecode
from 
employees
where
jobtitle='sales rep' or officecode=1
order by
officecode,jobtitle;

Between in where::

select 
firstname,lastname,jobtitle,officecode
from 
employees
where
officecode between 1 and 3
order by
officecode;

like in where

select 
firstname,lastname
from 
employees
where 
lastname like '%son'
order by
firstname

IN in where::

select 
firstname,lastname,officecode
from 
employees
where officecode in (1,2,3)
order by 
officecode;

is null in where::

select 
firstname,lastname,reportsto
from 
employees
where 
reportsto is null;

= equal
<> or!= 
<
>
>=
<=
<> or != equal 
select 
firstname,lastname,jobtitle
from 
employees
where
jobtitle <>'sales rep'

<= in where:
select 
firstname,lastname,officecode
from 
employees
where officecode <=5
order by 
officecode;

distinct in where:

select distinct
state,city
from 
customers
where 
state is not null
order by
state,city;


find customers who locate in lasvegas usa (query) credit limit greater than 100k

select 
customernumber,customername,city ,country,creditlimit
from 
customers
where
city='Las vegas' and country='usa' and
creditlimit>10000;


find the offices located in usa nad france:offices, country

select country from offices where country='usa' or 'france';
select country from offices where country in ('usa','france');

find the offices located not in usa nad france:offices, country

select country from offices where country not in ('usa','france');


find products whose buy prices between 90 and 100

select 
productCode,
productName,
buyPrice
from products
where buyPrice between 90 and 100;

select 
productCode,
productName,
buyPrice
from products
where buyPrice < 90 or buyprice>100;

find employees whose firstname starts with letter a

select 
employeenumber,
firstname,
lastname
from
employees
where
firstname  like 'a%';

find employees whose latname ends with letter on

select 
employeenumber,
firstname,
lastname
from
employees
where
lastname like '%on';

to search for inbetween value for escape sequence use \ backslash

select 
productcode,
productname
from 
products
where 
productcode like '%20%';

top 5 customers who have the highest credit

select 
customernumber,
customername,
creditLimit 
from
customers
order by creditLimit desc
limit 5;


find the customer who has the 2nd highest credit (1,1)

select 
customernumber,
customername,
creditLimit 
from
customers
order by creditLimit desc
limit 1,1;

find customers who do not have a sales representative

select 
customerName,
country,
salesrepemployeenumber
from
customers
where 
salesrepemployeenumber is null
order by
customerName















             
             
                
       
       
       
       
       
       
    
    



  
  
  

      
