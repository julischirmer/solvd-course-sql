update band_member set document_no = 12345678 where id = 5;

update hall set address = 'Albert 15' where id = 2;

update customer set email = 'new@email.com', address = 'new address' where id = 1;

update concert set hall_id = (select id from hall h where h.id = 3) where id = 1;

update ticket set concert_id = (select id from concert c where c.id = 2) where id = 2;

update staff set role_id = (select id from staff_roles sr where sr.description = 'usher') where id = 1;

update country set country_name = 'United States' where country_name = 'USA';

update payment set type_pay = 'International Transference' where id = 3;

update concert_has_artist set time_start = '09:00:00', time_end = '10:00:00' where id = 1;

update hall set country_id = (select id from country c where c.country_name = '4') where id = 3; 
