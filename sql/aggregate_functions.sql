select a.id, a.name, count(cha.concert_id) 'concerts'
from artist a
left join concert_has_artist cha
	on a.id = cha.artist_id
group by 1,2;

select a.id, a.name, count(cha.concert_id) 'concerts_per_artist'
from artist a
left join concert_has_artist cha
	on a.id = cha.artist_id
group by 1,2
having concerts >= 1;

select s.id, s.name, s.last_name, count(cs.concert_id) 'concerts_per_staff'
from staff s
left join concert_staff cs
	on s.id = cs.staff_id
group by 1,2,3;

select s.id, s.name, s.last_name, count(cs.concert_id) 'concerts_per_staff'
from staff s
left join concert_staff cs
	on s.id = cs.staff_id
group by 1,2,3
having concerts_per_staff >= 2;

select c.id, c.country_name, count(h.id) 'halls_per_country'
from country c
left join hall h
	on c.id = h.country_id
group by 1,2;

select c.id, c.country_name, count(h.id) 'halls_per_country'
from country c
left join hall h
	on c.id = h.country_id
group by 1,2
having halls_per_country = 2;

select c.id, c.country_name, count(a.id) 'artists_per_country'
from country c
left join artist a
	on c.id = a.country_id
group by 1,2;


select c.id, c.country_name, count(a.id) 'artists_per_country'
from country c
left join artist a
	on c.id = a.country_id
group by 1,2
having artists_per_country > 1;

select sector,sum(cost) 'total_tickets_price'
from ticket
group by 1;

select sector,sum(cost) 'total_tickets_price'
from ticket
group by 1
having total_tickets_price > 500;

select c.id, c.name, c.last_name, count(b.id) 'booking_per_customer'
from customer c
inner join booking b
	on c.id = b.customer_id
group by 1,2,3;

select c.id, c.name, c.last_name, count(b.id) 'booking_per_customer'
from customer c
inner join booking b
	on c.id = b.customer_id
group by 1,2,3
having booking_per_customer >= 1;

select a.id, a.name, count(bm.id) 'band_members_per_artist'
from artist a
left join band_member bm
	on bm.artist_id = a.id
group by 1,2;

select a.id, a.name, count(bm.id) 'band_members_per_artist'
from artist a
left join band_member bm
	on bm.artist_id = a.id
group by 1,2
having band_members_per_artist > 1;



