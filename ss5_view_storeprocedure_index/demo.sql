create database DataProducts;
use DataProducts;
create table Product(id int auto_increment primary key,
ProdcutCode varchar(52) ,
ProductName varchar(50),
ProductPrice int ,
ProductAmount int,
ProductDescription varchar(50),
ProductStatus varchar(50));


use DataProducts;
insert into Product values
(1,'A01','iPhone5',2300,10,'Hàng mới','còn hàng'),
(2,'A02','iPhone6',3500,11,'Hàng cũ','còn hàng'),
(3,'A03','iPhone7',1000,12,'Hàng mới','còn hàng'),
(4,'A04','iPhone8',5400,13,'Hàng cũ','còn hàng'),
(5,'A05','iPhone9',61200,14,'Hàng mới','hết hàng'),
(6,'A06','iPhone10',7200,15,'Hàng cũ','còn hàng'),
(7,'A07','iPhone11',8400,167,'Hàng mới','hêt hàng'),
(8,'A08','iPhone12',9500,17,'Hàng cũ','còn hàng');

-- "Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)"
Create unique index index_product on product(ProdcutCode);
explain select * from product where ProdcutCode = 'A06';
Create unique index index_prodouctName on product(productName ,productPrice);
explain select * from product where productName = 'iPhone10' and productPrice = '7200';

-- "Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view"
create view view_product as
select ProdcutCode, productName, productPrice, productStatus 
from product;
select * from view_product;
-- Tiến hành sửa đổi view
create or replace view view_products as
select ProdcutCode, productName, productPrice, productStatus 
from product
where productName = 'iPhone9';
select * from view_products;
-- Tiến hành xóa view
drop view view_products;

-- "Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id"
DELIMITER //
Create procedure show_product()
Begin
Select * from product;
end //
DELIMITER // ;

-- "gọi show_product"
call show_product();

-- them mot san pham

DELIMITER // 
create Procedure Add_Product
( in id int,in ProdcutCode varchar(52) ,in ProductName varchar(50),in ProductPrice int ,in ProductAmount int,in ProductDescription varchar(50),in ProductStatus varchar(50))
Begin
insert into Products
values(id,ProdcutCode,ProductName,ProductPrice,ProductAmount,ProductDescription,ProductStatus);
End//
DELIMITER ;

call Add_Product(9,'A003','den',100,1,'tot','ton nhieu');

select * from Products;

-- sua thong tin san pham theo id
DELIMITER // 
create procedure fix_index
(in idx int,in ProdcutCode varchar(52) ,in ProductName varchar(50),in ProductPrice int ,in ProductAmount int,in ProductDescription varchar(50),in ProductStatus varchar(50))
Begin 
update Products set
ProdcutCode=ProdcutCode,
ProductName =ProductName,
ProductPrice =ProductPrice,
ProductAmount =ProductAmount,
ProductDescription=ProductDescription,
ProductStatus =ProductStatus
where id=idx;
End //
DELIMITER ;
call fix_index(9,'A123','hah',100,1,'khong tot','qua nhieu hang');
select * from Products;

-- xoa san pham theo id
DELIMITER // 
create procedure delete_Products(in idx int)
Begin
delete from Products 
where id=idx;
End //
DELIMITER ;
