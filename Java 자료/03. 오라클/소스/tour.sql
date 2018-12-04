drop table famous_saying;

create table famous_saying(
            id number constraint famous_saying_id_pk primary key,
            statement varchar2(1000 char) constraint famous_saying_statement_nn not null,
            who varchar2(20 char) constraint famous_saying_who_nn not null
);

desc famous_saying;
------------------------------------------------------------------
drop table top100;

create table top100(
    id          number constraint top100_id_pk primary key,
    title       varchar2(100 char),
    region      varchar2(50 char),
    location    varchar2(80 char),
    content     varchar2(1000 char),
    address     varchar2(300 char),
    home_page    varchar2(300 char)
);

desc top100;