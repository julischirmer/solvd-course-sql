#Insertions
#Country
insert into country values (1,'Argentina'),
						   (2,'USA'),
                           (3,'Mexico'),
                           (4,'England');

# Hall
insert into hall values (1,'Royal Albert Hall','Penelope St. 145',10000,4),
						(2,'Downtown hall', 'Albert 10',45000, 2 ),
                        (3, 'Paradise hall', 'Coulin 89' ,25000, 2),
                        (4, 'River Plate Stadium','Av. Figueroa Alcorta 7597', 72000, 1),
                        (5, 'Azteca Stadium', 'Calz. de Tlalpan 3465', 87000, 3);
                        
#Role
insert into staff_roles values (1, 'receptionist'),
						(2, 'usher'),
                        (3, 'light manager'),
                        (4, 'sound manager');

#Staff
insert into staff values (1, 22222222, 'Nahuel', 'Perez', 1),
						 (2, 44444444, 'Damian', 'Salut', 1),
                         (3, 55555555, 'John', 'Fixter', 1),
                         (4, 66666666, 'Jane', 'Scott', 2),
                         (5, 77777777, 'Pedro', 'Asnar', 3),
                         (7, 88888888, 'Christian', 'Donnate', 3),
                         (8, 99999999, 'Julian', 'Azkuenaga', 4),
                         (9, 33333333, 'Peter', 'Lanzani', 4);
                         
#Instrument
insert into instrument values (1, 'electric guitar'),
							  (2, 'piano'),
                              (3, 'electric bass'),
                              (4, 'drums'),
                              (5, 'fiddle');
                              
#Artist
insert into artist values (1, 'Dua Lipa', 2),
						  (2, 'Rosalia', 3),
                          (3, 'Sia', 2),
                          (4, 'Miley Cyrus', 2),
                          (5, 'Bizarrap', 1),
                          (6, 'Adele', 4),
                          (7, 'Nicki Nicole', 1);
                          
#Band_member
insert into band_member values (1, 10101010, 'Juan', 'Salvatierra', 1, 1),
							   (2, 11101110, 'Pedro', 'Llorente', 2, 1),
                               (3, 12101210, 'Eduard', 'Steven', 4, 1),
                               (4, 15121512, 'Maria', 'Loven', 3, 1),
                               (5, 19234567, 'Elle', 'Amberson', 1, 2),
                               (6, 18101810, 'Patrik', 'Break', 3,2),
                               (7, 10151015, 'John', 'Elliot', 4,2),
                               (8, 16716716, 'Allison', 'Fogarty', 2,6),
                               (9, 14131413, 'Ashley', 'Hart', 5,6);
					
#Payment
insert into payment values (1,'Credit card'),
						   (2,'Debit card'),
                           (3,'Wire transfer');
                           
#Customer
insert into customer values (1, 10000001, 'Julian', 'Schirmer', 'Lopez st. 1214', '19991027','jschirmer@mail.com'),
							(2, 10000002, 'Anna', 'Iverson', 'Made st. 1023', '19760916', 'aiverson@mail.com'),
                            (3, 50000001, 'Dana', 'Klept', 'Stwart av. 455', 19860110, 'dklept@mail.com'),
                            (4, 50000002, 'Erin', 'Mooney', 'Rick st. 657', 20010321, 'emooney@mail.com'),
                            (5, 10000003, 'John', 'Landry', 'Split av. 435', 19660522, 'jlandry@mail.com'),
                            (6, 10000004, 'Pam', 'Spacey', 'Speed st. 902', 19641127, 'pspacey@gmail.com');
                            
#Concert
insert into concert values (1, '20221210','10:00:00',4),
						   (2, '20230115','18:00:00',1);

#Booking
insert into booking values (1,'20221210',1,1),
						   (2,'20221109',2,2),
                           (3,'20230102',3,2);
#concert_has_artist
insert into concert_has_artist values (1,1,2,'10:00:00','11:00:00'),
									  (2,1,1,'11:00:00','12:00:00'),
                                      (3,1,3,'12:00:00','13:00:00'),
                                      (4,2,6,'18:00:00','20:00:00');
                                      
#concert_staff
insert into concert_staff values (1,1,1),
								 (2,1,2),
                                 (3,2,1),
                                 (4,2,3),
                                 (5,2,4);
#Ticket
insert into ticket values (1,300,'A',13,"Gold",1,1),
						  (2,450,'H',28,"Platinum",2,1),
                          (3,700,'W',13,"Diamond",3, 2);                         