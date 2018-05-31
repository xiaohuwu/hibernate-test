
create table class_room (id integer not null auto_increment, className varchar(255), primary key (id))
create table student (id integer not null auto_increment, age integer not null, name varchar(255), room_id integer, primary key (id))
alter table student add constraint FKduyisoppncyi3kk56om5o4o5o foreign key (room_id) references class_room (id)
alter table EMPLOYEE drop foreign key FKgh5ho7v59ojrdrcb00nqq4sgb
drop table if exists DEPARTMENT
drop table if exists EMPLOYEE
create table DEPARTMENT (departmentId bigint not null auto_increment, DEPT_NAME varchar(255), primary key (departmentId))
create table EMPLOYEE (employee_id bigint not null auto_increment, birth_date date, cell_phone varchar(255), firstname varchar(255), lastname varchar(255), department_id bigint not null, primary key (employee_id))
alter table EMPLOYEE add constraint FKgh5ho7v59ojrdrcb00nqq4sgb foreign key (department_id) references DEPARTMENT (departmentId)
