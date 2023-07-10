create database nhasach;
use nhasach;
create table sach(
	id varchar(20) not null primary key,
    ten_sach varchar(50)  null,
    gia_ban varchar(50)  null,
    nam_xuat_ban int  null
);

create table khach_hang(
	id int not null auto_increment primary key,
     name varchar(50),
     ngay_sinh date,
     address varchar(100)
); 