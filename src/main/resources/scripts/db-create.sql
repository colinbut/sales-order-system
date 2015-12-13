create table address (address_id integer not null auto_increment, city varchar(15) not null, country varchar(20) not null, house_flat_no integer not null, postcode varchar(8) not null, street varchar(255) not null, primary key (address_id)) ENGINE=InnoDB
create table customer (customer_id integer not null auto_increment, customer_date_of_birth datetime not null, customer_email_address TEXT not null, customer_firstname varchar(50) not null, customer_lastname varchar(50) not null, customer_address_id integer, primary key (customer_id)) ENGINE=InnoDB
create table customer_payment_details (customer_payment_details_id integer not null auto_increment, customer_card_expiry_date datetime not null, customer_card_number varchar(16) not null, customer_reference varchar(20) not null, customer_id integer not null, primary key (customer_payment_details_id)) ENGINE=InnoDB
create table items (item_id integer not null auto_increment, item_name varchar(255) not null, item_price decimal(19,2) not null, primary key (item_id)) ENGINE=InnoDB
create table orders (order_id integer not null auto_increment, customer_id integer not null, primary key (order_id)) ENGINE=InnoDB
create table orders_items (order_id integer not null, item_id integer not null, primary key (order_id, item_id)) ENGINE=InnoDB
alter table customer add constraint FK_b95lvfwqwswe6953ms7i58koj foreign key (customer_address_id) references address (address_id)
alter table customer_payment_details add constraint FK_45wvux3gqtvc2s8k4r1312c0j foreign key (customer_id) references customer (customer_id)
alter table orders add constraint FK_astys1dv61mdlp0n0wx0574r2 foreign key (customer_id) references customer (customer_id)
alter table orders_items add constraint FK_erdocw5fhr37d4mkjg3d568pd foreign key (item_id) references items (item_id)
alter table orders_items add constraint FK_sbml7tdyps7g2gbfj9ul40yas foreign key (order_id) references orders (order_id)
