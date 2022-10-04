SELECT a.*, c.country_name 
FROM artist a 
INNER JOIN country c 
	ON a.country_id = c.id 
ORDER BY a.id;

SELECT c.*, h.name as 'hall_name', h.address, h.capacity, h.country_id, ct.country_name 
FROM concert c 
INNER JOIN hall h 
	ON h.id = c.hall_id 
INNER JOIN country ct 
	ON ct.id = h.country_id 
WHERE c.id = 2; 

SELECT * 
FROM concert c 
LEFT JOIN concert_has_artist ca 
	ON c.id = ca.concert_id 
LEFT JOIN concert_staff cs 
	ON c.id = cs.concert_id 
LEFT JOIN artist a 
	ON a.id = ca.artist_id 
LEFT JOIN staff s 
	ON s.id = cs.staff_id 
INNER JOIN hall h 
	ON c.hall_id = h.id 
INNER JOIN country ct 
	ON h.country_id = ct.id 
ORDER BY c.id;

SELECT t.*, b.date_book, b.customer_id, b.payment_id,cust.document_no, cust.name as 'customer_name', cust.last_name as 'customer_last_name', pay.type_pay, c.date_concert, c.start_time, c.hall_id, h.name as 'hall_name',h.country_id, country.country_name 
FROM ticket t 
INNER JOIN booking b 
	ON t.booking_id = b.id 
INNER JOIN concert c 
	ON t.concert_id = c.id 
INNER JOIN customer cust 
	ON cust.id = b.customer_id 
INNER JOIN payment pay 
	ON pay.id = b.payment_id 
INNER JOIN hall h 
	ON h.id = c.hall_id 
INNER JOIN country 
	ON country.id = h.country_id 
WHERE t.id is not null 
ORDER BY t.id;

SELECT t.*, b.date_book, b.customer_id, b.payment_id,cust.document_no, cust.name as 'customer_name', cust.last_name as 'customer_last_name', pay.type_pay, c.date_concert, c.start_time, c.hall_id, h.name as 'hall_name',h.country_id, country.country_name, cha.artist_id, art.name as 'artist_name' 
FROM ticket t 
INNER JOIN booking b 
	ON t.booking_id = b.id 
INNER JOIN concert c 
	ON t.concert_id = c.id 
INNER JOIN customer cust 
	ON cust.id = b.customer_id 
INNER JOIN payment pay 
	ON pay.id = b.payment_id 
INNER JOIN hall h 
	ON h.id = c.hall_id 
INNER JOIN country 
	ON country.id = h.country_id 
RIGHT JOIN concert_has_artist cha 
	ON cha.concert_id = c.id 
RIGHT JOIN artist art 
	ON cha.artist_id = art.id 
WHERE t.id is not null 
ORDER BY t.id;


