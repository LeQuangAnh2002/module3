CREATE DATABASE QuanLySinhVienPro;
USE QuanLySinhVienPro;
CREATE TABLE Class
(
    ClassID   INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME  NOT NULL,
    Status    BIT
);
CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

-- "Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’"
use quanlysinhvien;
select * from students
where StudentName like 'h%';
-- "Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12."
use quanlysinhvien;
select ClassID,ClassName,month(StartDate) as mount from class
where month(StartDate) = 12;

-- "Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5."
use quanlysinhvien;
select * from subject
where credit between 3 and 5 
;
-- "Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2."

use quanlysinhvien;
update students set ClassId  = 2
Where studentName like 'Hung%';

-- "Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần."
use quanlysinhvien;
select  S.StudentId,S.StudentName, Sub.SubName, M.Mark from students S
inner join Mark M on S.StudentId = M.StudentId join Subject Sub on Sub.SubId = M.SubId 
order by Mark desc;





