-- region truncate
truncate account;
truncate bank;
truncate employee;
truncate customer;
truncate customers_accounts;
-- endregion

-- region insert_accounts
insert into account
values (1, 10000, 'SPNGAT21XXX', 'AT696000017937184686');
insert into account
values (3, 102300, 'SPNGAT21XXX', 'AT711400062963235587');
insert into account
values (4, 100430, 'SPNGAT21XXX', 'AT413400046597217945');
insert into account
values (5, 100430, 'SPNGAT21XXX', 'AT441947036747586949');
insert into account
values (6, 100430, 'SPNGAT21XXX', 'AT591400011579543755');
insert into account
values (7, 100430, 'SPNGAT21XXX', 'AT533219578917593677');
-- endregion

-- region insert_banks
insert into bank
values (1, 'Sparkasse Neunkirchen', 1);
insert into bank
values (2, 'Sparkasse Linz', 4);
insert into bank
values (3, 'Sparkasse Linz', 4);
-- endregion

-- region insert_employee
insert into employee
VALUES (1, 'GLOBAL', 'Mäxl', 123984, 'Gecka', 1);
insert into employee
VALUES (2, 'GLOBAL', 'Dave', 12354, 'Kruss', 2);
insert into employee
VALUES (3, 'PRIVATE', 'AERES', 1, 'AERES', 1);
insert into employee
VALUES (4, 'PRIVATE', 'Daniel', 123984, 'Van Kastenhoof', 2);
insert into employee
VALUES (5, 'FACILITY', 'Däxl', 123984, 'Becka', 1);
insert into employee
VALUES (6, 'FACILITY', 'Eli', 123984, 'Rumi', 1);
insert into employee
VALUES (7, 'GLOBAL', 'Ferdi', 123984, 'Froh', 2);
-- endregion

-- region insert_customer
insert into customer
values (1, 'Lynn', '84352', 'Balykchy', 68754.73, 'Pierstorff', 'Boyda', '325325', 1);
insert into customer
values (2, 'Brice', '36116', 'Zherdevka', 11125.61, 'Northview', 'Minger', '397100', 2);
insert into customer
values (3, 'Karel', '2639', 'Dian-ay', 59899.57, 'Arapahoe', 'Itzkovsky', '4221', 1);
insert into customer
values (4, 'Whitney', '51', 'Leiwang', 78269.51, 'Gulseth', 'Sexcey', '21421', 1);
insert into customer
values (5, 'Ruttger', '11951', 'Zhangpu', 11041.62, 'Bunker Hill', 'Estabrook', '2142', 1);
insert into customer
values (6, 'Georgie', '7', 'Cibunar', 4042.42, 'Maple', 'Dymond', '4244535', 2);
insert into customer
values (7, 'Westley', '804', 'Ladoang', 70602.45, 'Talisman', 'Credland', '424535', 1);
-- endregion

-- region insert_customers_accounts
insert into customers_accounts
values (1, 2);
insert into customers_accounts
values (1, 3);
insert into customers_accounts
values (2, 2);
insert into customers_accounts
values (2, 4);
-- endregion