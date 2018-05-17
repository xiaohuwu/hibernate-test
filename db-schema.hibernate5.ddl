
create table class_room (id integer not null auto_increment, className varchar(255), primary key (id))
create table student (id integer not null auto_increment, age integer not null, name varchar(255), room_id integer, primary key (id))
alter table student add constraint FKduyisoppncyi3kk56om5o4o5o foreign key (room_id) references class_room (id)
