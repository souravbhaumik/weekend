SELECT DATNAME FROM PG_DATABASE;
CREATE DATABASE DUMMY;
DROP DATABASE DUMMY;
CREATE TABLE PERSON(
    ID INT,
    NAME VARCHAR(100),
    CITY VARCHAR(100)
);
INSERT INTO PERSON VALUES(1, 'Tinni', 'Mandarmoni');
INSERT INTO PERSON(id, name, city) VALUES(2, 'Sourav', 'Paushi');
INSERT INTO PERSON(id, name, city) VALUES(3, 'Garima', 'Contai'), (4, 'Shilpa', 'Bengaluru');
SELECT NAME, * FROM PERSON;
UPDATE PERSON SET CITY='Bangalore' WHERE NAME='Sourav';
CREATE TABLE customers (
    acc no INT PRIMARY KEY,
    name VARCHAR(IOO) NOT NULL,
    acc_type VARCHAR(50) NOT DEFAULT 'Savings'
);
CREATE TABLE EMPLOYEES (
    emp_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email varchar(100) not null unique,
    dept varchar(50),
    salary decimal(10,2) default 30000.00
);
Constraints

    not null
    primary key
    unique

    select currval('employees_emp_id_seq');
    SELECT setval('employees_emp_id_seq', 1) ;

Clauses

    where
    distinct
    order by
    limit
    like

    select * from employees where dept='IT';
    select * from employees where salary >= 50000;
    select * from employees where salary != 50000;
    select * from employees where dept='IT' or dept='Finance';
    select * from employees where dept in ('IT', 'HR');
    select * from employees where dept not in ('IT', 'HR');
    select * from employees where salary between 40000 and 60000;
    select distinct(dept) from employees;
    select * from employees order by first_name asc;
    select * from employees order by first_name asc, last_name desc;
    select * from employees limit 5;
    select * from employees where last_name like '%S%';
    select * from employees where length(dept)=2;
    select * from employees where dept like '__';
    select * from employees where first_name like '_a%';

    select count(*) from employees;
    select sum(salary) from employees;
    select avg(salary) from employees;
    select max(salary) from employees;
    select min(salary) from employees;

    select dept from employees group by dept;
    select dept, count(*) from employees group by dept;
    select dept, sum(salary) from employees group by dept;

    select concat(first_name, ' ', last_name) as full_name from employees;
    select concat_ws(' ', first_name, last_name) as full_name from employees;
    select concat_ws('_', first_name, last_name) as full_name from employees;
    select concat(concat(first_name, ' '), last_name) as full_name from employees;

    select substr(email, 0, 4) from employees;

    select replace(email, '@example.com', '@gmail.com') from employees;

    select reverse(concat(first_name, ' ', last_name)) from employees;

    select length(first_name) from employees;
    select * from employees where length(first_name) >= 4;

    select upper(first_name) from employees;

    select left(email, 5) from employees;   // returns 5 characters from left
    select right(email, 12) from employees; // returns 12 characters from right

    select trim('      Hello      world!     ');            //  Hello      world!
    select length('      Hello      world!     ');          // 28
    select length(trim('      Hello      world!     '));    // 17

    select position('@' in email) from employees;

    select concat(substr(dept,1,1), emp_id, first_name) from employees;

    alter table employees rename to employee;
    alter table employee rename column last_name to lname;
    alter table employee rename column first_name to fname;
    alter table employee alter column email set data type varchar(150);
    alter table employee alter column email set default '@gmail.com';
    alter table employee alter column email drop default;

    alter table person add column mobile_no varchar(15) check (length(mobile_no) >=10);
    alter table person drop constraint person_mobile_no_check;
    alter table person add constraint person_mobile_no_less_than_10 check (length(mobile_no) >=10);

CASE

    select first_name, salary,
        case
            when salary>=50000 then 'High' else 'low'
    end as sal_cat
    from employees order by sal_cat;

    select emp_id, first_name, salary, case when salary >= 55000 then 'high' when salary > 45000 and salary < 55000 then 'medium' when salary <= 45000 then 'low' end as sal_cat from employees order by sal_cat desc;

    SELECT
        CASE
            WHEN SALARY > 50000 THEN 'HIGH'
            WHEN SALARY BETWEEN 48000 AND 55000 THEN 'MID'
            ELSE 'LOW'
        END AS SAL_CAT, COUNT(EMP_ID)
    FROM EMPLOYEES
    GROUP BY SAL_CAT;

CROSS JOIN

    Every row from one table is combined with every row from another table.

    select * from customers cross join orders;

INNER JOIN

    Returns only the rows where there is a match between the specified columns in both the left(or first) or right(or second) tables.

    select * from customers c inner join orders o on c.cust_id=o.cust_id;
    select c.cust_name, count(*), sum(o.price) from customers c inner join orders o on c.cust_id=o.cust_id group by cust_name;

Left Join

    Returns all data from the left table and only matching rows from the right table.

    select * from customers c left join orders o on c.cust_id=o.cust_id;

Right Join

    Returns all the data from right table and only matching rows from the left table.

    select * from orders o right join customers c on c.cust_id=o.cust_id;

STORED Routine

    An SQL statement or set of SQL statements that can be stored in a database server which can be called no. of times.

Stored procedure

    Set of SQL statements and procedural logic that can perform operations such as inserting, updating, deleting, and querying data.