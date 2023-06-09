use quanlysinhvien;
Insert into Class(ClassID,ClassName,StartDate,Status) values(1,'A1','2008-12-10',1
);
Insert into Class(ClassName,StartDate,Status) values('A2','2008-12-12',1
);
Insert into Class(ClassName,StartDate,Status) values('A3','2008-05-11',1
);

use quanlysinhvien;
Insert into Students(StudentName,Address,Phone,Status,ClassId) values('Hung','Ha Noi','0912113113',1,1);
Insert into Students(StudentName,Address,Phone,Status,ClassId) values('Manh','HCM','0912113113',1,2);
Insert into Students(StudentName,Address,Phone,Status,ClassId) values('Hung','Da Nang','0912113113',1,3);
Insert into Students(StudentName,Address,Phone,Status,ClassId) values('Hien','Da Nang','0912113113',0,3);

use quanlysinhvien;
Insert into Subject(SubName,Credit,Status) values('CF', 5, 1),
       ('C', 6, 1),
       ( 'HDJ', 5, 1),
       ( 'RDBMS', 10, 1);
use quanlysinhvien;
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (2, 2, 10, 2),
       (3, 3, 12, 1);
       
"Hiển thị danh sách tất cả các học viên" 
use quanlysinhvien;
select * from students;
"Hiển thị danh sách các học viên đang theo học."
use quanlysinhvien;
select * from students
where status = true;
"Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ."
use quanlysinhvien;
select * from subject
where credit > 10;
"Hiển thị danh sách học viên lớp A1"
use quanlysinhvien;
select students.studentID, students.studentName, class.className from Students students
inner join Class class on  students.ClassId = class.ClassId
where class.ClassName = 'A1';
"Hiển thị điểm môn CF của các học viên."
use quanlysinhvien;
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Students S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';