select department_name
from departments
where department_id=(select department_id
                     from employees
                     where last_name='Lee');
                     
select department_name
from departments
where department_id=(select department_id
                     from employees);
                     
select last_name, salary
from employees
where salary > (select avg(salary)
                from employees);

SELECT last_name, department_id
FROM employees
WHERE department_id=(
        select department_id
        from employees
        where last_name='Jones')
        and last_name<>'Jones';

SELECT last_name, salary
FROM employees
WHERE department_id = (
        SELECT department_id
        FROM departments
        WHERE department_name='Sales');

SELECT department_id, last_name
FROM employees
WHERE department_id in (
        SELECT department_id
        FROM departments
        WHERE location_id =(
                SELECT location_id
                FROM locations
                WHERE city='Seattle')
        );

select *
from ( select last_name,salary
        from employees
        where department_id =100);

SELECT last_name, department_id
FROM employees
WHERE department_id IN(
            SELECT DISTINCT department_id
            FROM employees
            WHERE salary >=10000);
            
SELECT last_name, salary
FROM employees
WHERE salary > ALL(
            SELECT salary
            FROM employees
            WHERE department_id=30);
            
select last_name, salary
from employees
where salary>(
        select min(salary)
        from employees
        group by department_id
        Having department_id=30);

select rowid, employee_id,first_name, last_name
from employees;

select rowid,rownum,department_name
from departments;

drop table emp01;

create table emp01(
        EMPNO number(4) primary key,
        ENAME varchar2(20),
        SAL number(7,2)
        );
        
select * from emp01;

desc emp01;

create table DEPT01(
        DEPTNO number(2),
        DNAME varchar2(14),
        LOC varchar2(13)
        );
        
create table emp02
as
select * from employees;

select * from emp02;
            
create table emp03
as
select employee_id, first_name, last_name from employees;

select * from emp03;

        
create table emp04
as
select * from employees
where department_id=80;

select * from emp04;

        
create table emp05
as
select * from employees
where 1=0;

select * from emp05;

drop table dept;

create table dept
as
select * from departments
where 1=0;

alter table  emp01
add(job varchar2(9));

desc emp01;

alter table dept01
add(dmgr varchar2(10));

desc dept01;

alter table emp01
modify(job varchar2(30));
desc emp01;

alter table dept01
modify(dmgr number(4));

desc dept01;

alter table emp01
drop column job;

desc emp01;

alter table dept01
drop column dmgr;

desc dept01;    

alter table emp02
set unused(job_id);

select * from emp02;

desc emp02;

alter table emp02
drop unused columns;

desc user_tables;

select * from user_tables;














