-- add addresses
-- address (in particular postcodes) are fake - random generated using https://www.doogal.co.uk/PostcodeGenerator.php
insert into address (city, country, house_flat_no, postcode, street) values ('London', 'UK', 50, 'HD4 5HB', 'Rodney Street');


-- add customers
insert into customer (customer_date_of_birth, customer_email_address, customer_firstname, customer_lastname, customer_address_id) values
('2000-12-21 00:00:00', 'firstname1.lastname1@email.com', 'firstname1', 'lastname1', 1);


-- add customer payment details
-- Note* Credit Card numbers are fake - random generated using http://www.getcreditcardnumbers.com/
insert into customer_payment_details (customer_card_expiry_date, customer_card_number, customer_reference, customer_id) values
('2015-12-31 00:00:00', '1234567812345678', 'customer-ref-1', 1);

-- add items
insert into items (item_name, item_price) values
('test-item1',23.2);

-- add orders
insert into orders (customer_id) values (1);

-- link orders-items
insert into orders_items (order_id, item_id) values (1, 1);
