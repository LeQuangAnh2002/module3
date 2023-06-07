create database QuanLySinhVien;
use quanlysinhvien;
create table Class(
	ClassID int not null primary key auto_increment,
    ClassName varchar(60) not null,
    StartDate DateTime not null,
    Status Bit
);
create table Students(
	StudentID int not null primary key auto_increment,
    StudentName varchar(30) not null,
    Address varchar(50),
    Phone varchar(20),
    Status Bit,
    ClassId int not null,
    foreign key(ClassID) references Class(ClassID)
);
create table Subject(
	SubID int not null primary key auto_increment,
    SubName varchar(30) not null,
    Credit tinyint Not null default  1 CHECK (Credit >= 1),
    Status bit default 1
);
create table Mark(
	MarkID int not null auto_increment primary key,
    SubID int not null,
    StudentID int not null,
    Mark float default 0 check (Mark between 0 and 100),
    ExamTimes tinyint default 1,
    unique(SubID,StudentID),
    foreign key(SubID) references Subject(SubID),
    foreign key(StudentID) references Students(StudentID)
);