alter table customer
add country_id int;

alter table customer
add FOREIGN KEY (country_id) REFERENCES country(id) ON UPDATE CASCADE ON DELETE NO ACTION;

alter table customer
drop address;

alter table staff
add country_id int;

alter table staff
add FOREIGN KEY (country_id) REFERENCES country(id) ON UPDATE CASCADE ON DELETE NO ACTION;