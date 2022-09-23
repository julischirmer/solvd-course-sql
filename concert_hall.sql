DROP DATABASE IF EXISTS hall_concert;
CREATE DATABASE hall_concert;
USE hall_concert;

DROP TABLE IF EXISTS country;
CREATE TABLE country(
	id INT,
    country_name VARCHAR(30),
    PRIMARY KEY (id));

DROP TABLE IF EXISTS hall;
CREATE TABLE hall (
	id INT,
	name VARCHAR(20),
    address VARCHAR(45),
    capacity INT,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY(country_id) REFERENCES country(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS payment;
CREATE TABLE payment (
	id INT,
    type_pay VARCHAR(30),
    PRIMARY KEY (id));
    
DROP TABLES IF EXISTS customer;
CREATE TABLE customer(
	id INT,
    document_no INT,
    name VARCHAR(30),
    last_name VARCHAR(30),
    address VARCHAR (45),
    birthday DATE,
    email VARCHAR (45),
    PRIMARY KEY (id));

DROP TABLE IF EXISTS booking;
CREATE TABLE booking(
	id INT,
    date_book DATETIME,
    customer_id INT,
    payment_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (payment_id) REFERENCES payment(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS staff_roles;
CREATE TABLE staff_roles(
	id INT,
    description VARCHAR(45),
    PRIMARY KEY(id));
    
DROP TABLE IF EXISTS staff;
CREATE TABLE staff(
	id INT,
    document_no INT,
    name VARCHAR(30),
    last_name VARCHAR(30),
    role_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (role_id) REFERENCES staff_roles(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS artist;
CREATE TABLE artist(
	id INT,
    name VARCHAR(30),
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS concert;  
CREATE TABLE concert(
	id INT,
    date_concert DATE,
    start_time TIME,
    hall_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (hall_id) REFERENCES hall(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket(
	id INT,
    cost DOUBLE,
    row_letter CHAR(1),
    seat_no INT,
    sector VARCHAR(45),
    booking_id INT,
    concert_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY (booking_id) REFERENCES booking(id) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (concert_id) REFERENCES concert(id) ON UPDATE CASCADE ON DELETE NO ACTION);

DROP TABLE IF EXISTS concert_staff;
CREATE TABLE concert_staff(
	concert_id INT,
    staff_id INT,
    date DATE,
    PRIMARY KEY (concert_id,staff_id),
    FOREIGN KEY (concert_id) REFERENCEs concert(id) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (staff_id) REFERENCES staff(id) ON UPDATE CASCADE ON DELETE NO ACTION);

DROP TABLE IF EXISTS instrument;
CREATE TABLE instrument(
	id INT,
    instrument_name VARCHAR(40),
    PRIMARY KEY (id));

DROP TABLE IF EXISTS band_member;
CREATE TABLE band_member(
	id INT,
    document_no INT,
    name VARCHAR(30),
    last_name VARCHAR(30),
    instrument_id INT,
    artist_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (instrument_id) REFERENCES instrument(id) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (artist_id) REFERENCES artist(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
DROP TABLE IF EXISTS concert_artist;
CREATE TABLE concert_has_artist(
	concert_id INT,
    artist_id INT,
    time_start TIME,
    time_end TIME,
    PRIMARY KEY (concert_id, artist_id),
    FOREIGN KEY (concert_id) REFERENCES concert(id) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (artist_id) REFERENCES artist(id) ON UPDATE CASCADE ON DELETE NO ACTION);
    
    

    
    
    