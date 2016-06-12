-- add addresses
-- address (in particular postcodes) are fake - random generated using https://www.doogal.co.uk/PostcodeGenerator.php
insert into address (city, country, house_flat_no, postcode, street) values
('London', 'UK', 50, 'HD4 5HB', 'Rodney Street'),
('Manchester', 'UK', 23, 'SO24 9NF', 'Albert Square'),
('Leeds', 'UK', 556, 'SA15 5NW', 'Tomson Road'),
('Birmingham', 'UK', 128, 'DL8 3AR', 'Milestone Alley'),
('Glasgow', 'UK', 16, 'LL63 5EY', 'Cheap Lane'),
('Newcastle', 'UK', 8, 'WS4 1LP', 'Fife Crescent'),
('Cardiff', 'UK', 3972, 'LL28 5BG', 'Winston Park'),
('Edinburgh', 'UK', 1, 'G32 0LG', 'Victoria Place'),
('Derby', 'UK', 12, 'SK13 2BA', 'Storm Gate'),
('Sheffield', 'UK', 32, 'PL32 9QG', 'Hung Row');


-- add customers
insert into customer (customer_date_of_birth, customer_email_address, customer_firstname, customer_lastname, customer_address_id) values
('2000-12-21 00:00:00', 'firstname1.lastname1@email.com', 'firstname1', 'lastname1', 1),
('2000-12-21 00:00:00', 'firstname2.lastname2@email.com', 'firstname2', 'lastname2', 2),
('2000-12-21 00:00:00', 'firstname3.lastname3@email.com', 'firstname3', 'lastname3', 3),
('2000-12-21 00:00:00', 'firstname4.lastname4@email.com', 'firstname4', 'lastname4', 4),
('2000-12-21 00:00:00', 'firstname5.lastname5@email.com', 'firstname5', 'lastname5', 5),
('2000-12-21 00:00:00', 'firstname6.lastname6@email.com', 'firstname6', 'lastname6', 6),
('2000-12-21 00:00:00', 'firstname7.lastname7@email.com', 'firstname7', 'lastname7', 7),
('2000-12-21 00:00:00', 'firstname8.lastname8@email.com', 'firstname8', 'lastname8', 8),
('2000-12-21 00:00:00', 'firstname9.lastname9@email.com', 'firstname9', 'lastname9', 9),
('2000-12-21 00:00:00', 'firstname10.lastname10@email.com', 'firstname10', 'lastname10', 10);



-- add customer payment details
-- Note* Credit Card numbers are fake - random generated using http://www.getcreditcardnumbers.com/
insert into customer_payment_details (customer_card_expiry_date, customer_card_number, customer_reference, customer_id) values
('2015-12-31 00:00:00', '1234567812345678', 'customer-ref-1', 1),
('2015-12-31 00:00:00', '4024007135995586', 'customer-ref-2', 2),
('2015-12-31 00:00:00', '4532754928070797', 'customer-ref-3', 3),
('2015-12-31 00:00:00', '4532790030107846', 'customer-ref-4', 4),
('2015-12-31 00:00:00', '4929126881917390', 'customer-ref-5', 5),
('2015-12-31 00:00:00', '4929337860089115', 'customer-ref-6', 6),
('2015-12-31 00:00:00', '5567638144721645', 'customer-ref-7', 7),
('2015-12-31 00:00:00', '5512296550494052', 'customer-ref-8', 8),
('2015-12-31 00:00:00', '5214682212584722', 'customer-ref-9', 9),
('2015-12-31 00:00:00', '5467916103505618', 'customer-ref-10', 10);


-- add items
insert into items (item_name, item_price) values
('test-item1',23.2),
('test-item2',25.2),
('test-item3',12.2),
('test-item4',67.2),
('test-item5',34.2),
('test-item6',09.2),
('test-item7',18.2);

-- add orders
insert into orders (customer_id) values (1);
insert into orders (customer_id) values (2);
insert into orders (customer_id) values (3);
insert into orders (customer_id) values (4);
insert into orders (customer_id) values (5);
insert into orders (customer_id) values (1);

-- link orders-items
insert into orders_items (order_id, item_id) values (1, 1), (1, 2);
