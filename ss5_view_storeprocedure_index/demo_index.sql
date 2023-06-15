use classicmodels;

-- "thêm chỉ mục cho bảng customers"
alter table customers add index idx_customerName(customerName);

explain select * from customers where customerName = 'Land of Toys Inc.';
-- "possible_keys : Đưa ra những Index có thể sử dụng để query
-- key : và Index nào đang được sử dụng
-- key_len : Chiều dài của từng mục trong Index
-- ref : Cột nào đang sử dụng
-- rows : Số hàng (rows) mà MySQL dự đoán phải tìm
-- extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”"
-- "type : Đây là thông tin quan trọng, nó cho chúng ta biết kiểu query nào nó đang sử dụng. Mức độ từ tốt nhất đến chậm nhất như sau: system, const, eq_ref, ref, range, index, all"

-- "Để xoá chỉ mục trong bảng"
ALTER TABLE customers DROP INDEX idx_customerName;