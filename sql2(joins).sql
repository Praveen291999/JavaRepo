use trainingdb;

create table members(
member_id int auto_increment,
name varchar(100) ,
primary key(member_id)
);
create table committees(
committee_id int auto_increment,
name varchar(100),
primary key(committee_id)
);


insert into members(name) 
values('john'),('jane'),('mary'),('david'),('amelia');

insert into committees(name) 
values('john'),('mary'),('amelia'),('joe');
 
 inner join syntax
 
 select column_list
 from tab1
 innerjoin tab2 0N/using (columnname)
 
 find members who are also committee members
 
 select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 inner join committees c on m.name= c.name;
 
 
select column_list
from table1
left join table2 on join condition

 select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 left join committees c on m.name= c.name;


 select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 right join committees c on m.name= c.name;
 
 find members who are not committee members
 
select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 left join committees c on m.name= c.name
 where c.committee_id is null;
 
 select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 left join committees c on m.name= c.name
 where c.committee_id is null;
 
 
cross join::

 select 
 m.member_id,
 m.name as members,
 c.committee_id,
 c.name as committee
 from
 members m 
 cross join committees c

join three tables

select 
orderNumber,
orderDate,
orderLineNumber,
productname,
quantityOrdered,
priceEach
from
orders
inner join
 orderdetails using(ordernumber)
 inner join 
 products using(productcode)
 order by
 orderNumber,
 orderlinenumber;
 
 find the sales price of the product whose code is s10_1678  that is less than the manufacturer suggested  retail price (MRP) for th

select 
ordernumber,
productname,
mrp,
priceEach
from
products p
inner join orderdetails o
on p.productcode=o.productcode
and p.mrp>o.priceEach
where
p.productcode='S10_1678';


self join::

select
concat(m.lastname,',',m.firstname)as Manager,
concat(e.lastname,',',e.firstname)as 'direct report'
from 
employees e
inner join  employees m on
m.employeenumber=e.reportsTo
order by 
manager

as manager is null use the following to get as top manager:(left join)

select
ifnull(concat(m.lastname,',',m.firstname),'Top Manager')as Manager,
concat(e.lastname,',',e.firstname)as 'direct report'
from 
employees e
left join  employees m on
m.employeenumber=e.reportsTo
order by 
manager desc

to get count of the reportees to the manager:use count(*)

select
ifnull(concat(m.lastname,',',m.firstname),'Top Manager')as Manager,
count(*)
from 
employees e
left join  employees m on
m.employeenumber=e.reportsTo
group by
manager
order by 
manager desc

create table products1(
id int primary key auto_increment,
product_name varchar(100),
price decimal(13,2)
);

create table stores(
id int primary key auto_increment,
store_name varchar(100)
);

create table sales(
product_id int,
store_id int,
quantity decimal(13,2) not null,
sales_date date not null,
primary key(product_id,store_id),
foreign key(product_id)	
references products1 (id)
		on delete cascade on update cascade,
	foreign key(store_id)
    references stores (id)
    on delete cascade on update cascade
    );


insert into products1(product_name,price)
values('iphone',699),
('ipad',599),
('mac',1099);

insert into stores(store_name)
values('north'),
('south');

insert into sales (store_id,product_id,quantity,sales_date)
values(1,1,20,'2021-01-05'),
(1,2,15,'2021-01-02'),
(1,3,25,'2021-01-05'),
(2,1,30,'2021-01-02'),
(2,2,35,'2021-01-05');

find total sales for each store and product

total sales=quantity*price

select 
store_name,
product_name,
sum(quantity*price)as revenue
from 
sales
inner join 
products1 on products1.id=sales.product_id
inner join
	stores on stores.id=sales.store_id
group by
store_name,product_name;

cross join::::::
select
 store_name,product_name                      
 from stores
 cross join
 products1;
 
 select
 b.store_name,
 a.product_name,
 ifnull(c.revenue,0)as revenue
 from
	products1 as a
	cross join
stores as b
	left join
    (select
    stores.id as store_id,
    products1.id as product_id,
    round(sum(quantity*price),0)as revenue
from 
	sales
inner join products1 on products1.id=sales.product_id
group by stores.id,products1.id) as c on c.store_id=b.id
	And c.product_id=a.id
order by b.store_name;


counting :example from orsers table
select
	status,
    count(ordernumber)
    from
    orders
    group by status;
 
 select * from orders;
 
 to get the total amount of all orders by status (order and orderdetails)
 
 select 
      o.ordernumber,
      o.status,
      sum(od.quantityordered*od.priceEach)as amount
      from
		orders o
        inner join orderdetails od
        using (ordernumber)
        group by 
        ordernumber,status;
 
 
 to get only for particular order number (use  having)
 
 select 
      o.ordernumber,
      o.status,
      sum(od.quantityordered*od.priceEach)as amount
      from
		orders o
        inner join orderdetails od
        using (ordernumber)
        group by 
        ordernumber,status
		having ordernumber=10100;
        
        
subqueries:::

return the employees who work in offices located in usa

     first get the offices in usa in subquery by in clause

select 
	lastname,firstname
    from
		employees
	where
		officecode in (select             
				officecode
			from
				offices
			where
				country='USA');
                
return the customer who has the highest payement

select 
customernumber,
checknumber
amount
from
	payments
where
	amount=(select max(amount) from payments);
	
find customers whose payeent are greater than the average payement subquery

select 
customernumber,
checknumber
amount
from
	payments
where
	amount>(select
				avg(amount)
                from
                payments);
        
 
 
 find cust who had not placed any orders
 
 
 select
	customername
from 
    customers
where
	customernumber not in (select distinct 
								customernumber
                                from
                                orders);
    
 find the custtomer who has atleast one order
 
 select
	customernumber,
    customername
from
	customers
where
	exists(
    select
			1
		from 
			orders
            where
            orders.cutomernumber=customers.customernumber);
            
            
find the customers who do not have any orders

select
	customerNumber,
    customerName
from
	customers
where
	not exists(
    select
			1
		from 
			orders
            where
            orders.cutomerNumber=customers.customerNumber);
            
            
            
union:::

syntax:
select column_list from table_list
union [distinct| all]

conditions::

1.the data types of the column must be the same.
2.the order and number of columns that appear in all select statements must be the same


select
	 contactfirstname,
     contactLastName
from
	customers
union
select
firstname,lastname
from 
employees;


select
	concat(firstname,'',lastname)fullname,
    'Employee' as contactType
    from employees
    
    union
    select
		concat(contactFirstName,'',contactLastName),
        'Customer' as contactType
	from
    customers
    order by
    fullname;
    
    
    select
	concat(firstname,'',lastname)fullname,
    'Employee' as contactType
    from employees
    
    union
    select
		concat(contactFirstName,'',contactLastName),
        'Customer' as contactType
	from
    customers
    order by
    1 or 2;  1 for 1st column and 2 for 2nd column
    
syntax:
select select_list1
from table_name1
minus
select select_list2
from table_name2;

syntax:
select column_list
from table1
intersect
select column_list
from table2



		
    
    
    
    
