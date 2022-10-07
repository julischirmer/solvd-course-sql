delete from instrument where id = 1;

delete from concert where date_concert = '20221210';

delete from artist where name = 'Dua Lipa';

delete from ticket where sector = 'Gold' and cost <= 200;

delete from customer where birthday is null;

delete from hall where country_id = (select id from country c where c.country_name = 'Mexico');

delete from band_member where name = 'Juan' and last_name = 'Salvatierra';

delete from booking where date_book < '20200101';

delete from artist where country_id = (select id from country c where c.country_name = 'Argentina');

delete from staff where country_id =  (select id from staff_roles where description = 'usher');

