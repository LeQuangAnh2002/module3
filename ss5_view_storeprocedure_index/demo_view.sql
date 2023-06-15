use classicmodels;
CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;


--  " Cập nhật view customer_views: "
 CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';
select * from customer_views;

-- "xoá view customer_views"
DROP VIEW customer_views;