select *
from concert c
inner join hall h
	on c.hall_id = h.id
right join concert_has_artist cha
	on cha.concert_id = c.id
right join artist a
	on a.id = cha.artist_id
right join country
	on a.country_id = country.id
right join band_member bm
	on bm.artist_id = a.id
right join instrument i
	on i.id = bm.instrument_id
right join concert_staff chs
	on chs.concert_id = c.id
right join staff s
	on s.id = chs.staff_id
right join staff_roles sr
	on sr.id = s.role_id
right join ticket t
	on t.concert_id = c.id
right join booking b
	on b.id = t.booking_id
right join customer cust
	on cust.id = b.customer_id
right join payment p
	on p.id = b.payment_id;


    