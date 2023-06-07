create database if not exists demo_ss2;
use demo_ss2;
create table jame(
 account varchar(255) primary key,
 password varchar(255) default '123'
);
create table room(
	id int auto_increment primary key,
    room_name varchar(255) 
);
create table class(
	id int auto_increment primary key,
    class_name varchar(255),
    id_room int,
    foreign key(id_room) references room(id)
);
create table student(
	id int auto_increment primary key,
    name varchar(50),
    dob date,
    gender bit,
    email varchar(255) unique not null,
    point double,
    account_id varchar(255),
    id_class int,
    foreign key(account_id) references jame(account),
    foreign key(id_class) references class(id)
);
create table teacher(
	id int auto_increment primary key,
    name varchar(50),
    dob date,
    salary int
);
create table teacher_class(
	id_class int,
    id_teacher int,
    primary key(id_class,id_teacher),
    foreign key(id_class) references class(id),
    foreign key(id_teacher) references teacher(id)
);