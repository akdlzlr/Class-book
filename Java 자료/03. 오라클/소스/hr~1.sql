drop table famous_saying;

create table famous_saying(
            id number primary key,
            statement varchar2(1000 char) not null,
            who varchar2(20 char) not null
);

desc famous_saying;
------------------------------------------------------------------
drop table top100;

create table top100(
    id          number primary key,
    title       varchar2(100 char),
    region      varchar2(50 char),
    location    varchar2(80 char),
    content     varchar2(1000 char),
    address     varchar2(300 char),
    home_page    varchar2(300 char)
);

desc top100;
------------------------------------------------------------------
insert into dept01
(deptno, dname, loc)
values(10, 'ACCOUNTING','NEW YORK');
select * from dept01;
------------------------------------------------------------------
insert into dept01
(deptno, dname, loc)
values('11a', 'ACCOUNTINGasdfasdfasasdfdfsfdasfdsasfdsasdfsasf','NEW YORK');
------------------------------------------------------------------
insert into dept01
(deptno, dname)
values(30,'SALES');

select * from dept01;
desc dept01;
------------------------------------------------------------------
drop table dept02;
create table dept02
as
select * from departments where 1=0;

insert into dept02
select * from departments;

select * from dept02;
------------------------------------------------------------------
-- 다중행 입력
create table emp_hr
as
select employee_id, first_name, last_name, hire_date
from employees
where 1=0;

create table emp_mgr
as
select employee_id, first_name, last_name, manager_id
from employees
where 1=0;

insert all
into emp_hr values(employee_id,first_name,last_name,hire_date)
into emp_mgr values(employee_id,first_name,last_name,manager_id)
select employee_id,first_name,last_name,hire_date,manager_id
from employees
where department_id=80;

select * from emp_hr;
select * from emp_mgr;

------------------------------------------------------------------
-- update 문
drop table emp01;
create table emp01
as
select * from employees;

update emp01
set department_id=100;

alter table emp01
add (update_date date);

update emp01
set update_date=sysdate;


select update_date from emp01;

------------------------------------------------------------------
-- 
update emp01
set salary = salary*1.8;

select * from emp01;

------------------------------------------------------------------
-- 특정 행만 변경
drop table emp01;
create table emp01
as
select * from employees;

update emp01
set department_id=30
where department_id=10;

select * from emp01;

------------------------------------------------------------------
--
update emp01
set salary = salary*2
where salary <=5000;

select salary from emp01;

-----------------------------------------------------------------
update emp01
set hire_date=sysdate
where substr(hire_date,1,2)='03';

-----------------------------------------------------------------
update emp01
set salary = salary-5000
where salary > 10000;

-----------------------------------------------------------------
drop table dept02;

create table dept02
as
select * from dept01;

delete from dept02;

select * from dept02;

-------------------------------------------------------------------


