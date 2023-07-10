create Database demo;
use demo;
create table user(
 id int(3) not null auto_increment,
 name varchar(120) not null,
 email varchar(120) not null,
 country varchar(120),
 primary key(id)
);

use demo;
insert into user(name,email,country) value ('Minh','minh@codegym.vn','Viet Nam'),
('Kante','kante@che.uk','Kenia');