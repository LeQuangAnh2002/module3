-- "DELIMITER // dùng để phân cách bộ nhớ lưu trữ thủ tục Cache và mở ra một ô lưu trữ mới.
-- CREATE PROCEDURE findAllCustomers() dùng để khai báo tạo một Procedure mới, trong đó findAllCustomers chính là tên thủ tục còn hai từ đầu là từ khóa.
-- **BEGIN và END; // ** dùng để khai báo bắt đầu của Procedure và kết thúc Procedure
-- **DELIMITER ; ** đóng lại ô lưu trữ",
DELIMITER //

create procedure findAllCustomers()
begin
select * from customers;
end //

DELIMITER //;
-- "Cách gọi procedure"
call findAllCustomers();
-- "Lệnh Drop để xóa đi Procedure "
DROP PROCEDURE IF EXISTS `findAllCustomers`


-- "Tham số loại IN"
DELIMITER //

create procedure getCusById
(IN cusNum int(11))
BEGIN
SELECT *FROM CUSTOMERS WHERE customerNumber = cusNum;

END //
DELIMITER //;
-- "Gọi store procedure" 
call getCusById(175);

-- "Tham số loại OUT"
DELIMITER //
CREATE procedure GetCustomersCountByCity(
	IN in_city varchar(50),
    out total INT
)
BEGIN
select count(customerNumber)
into total
from customers
where city = in_city;
END//
DELIMITER //;
-- "Gọi store procedure:"
Call GetCustomersCountByCity('Lyon',@total);

-- "Tham số loại INOUT"
DELIMITER //

CREATE PROCEDURE SetCounter(

    INOUT counter INT,

    IN inc INT

)

BEGIN

    SET counter = counter + inc;

END//

DELIMITER ;
-- "Gọi store procedure:"
SET @counter = 1;

CALL SetCounter(@counter,1); -- 2

CALL SetCounter(@counter,1); -- 3

CALL SetCounter(@counter,5); -- 8

SELECT @counter; -- 8
