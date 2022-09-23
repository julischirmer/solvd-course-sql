#Insertions
#Country
insert into country values (1,'Argentina'),
						   (2,'USA'),
                           (3,'Mexico'),
                           (4,'England');

# Hall
insert into hall values (1,'Royal Albert Hall','Penelope St. 145',4 ,10000),
						(2,'Downtown hall', 'Albert 10', 2 ,45000),
                        (3, 'Paradise hall', 'Coulin 89', 2 ,25000),
                        (4, 'River Plate Stadium','Av. Figueroa Alcorta 7597', 1, 72000),
                        (5, 'Azteca Stadium', 'Calz. de Tlalpan 3465', 3, 87000);
                        
#Role
insert into role values (1, 'receptionist'),
						(2, 'usher'),
                        (3, 'light manager'),
                        (4, 'sound manager');

#Staff
insert into staff values (1, 'dni', 22222222, 'Nahuel', 'Perez', 1),
						 (2, 'dni', 44444444, 'Damian', 'Salut', 1),
                         (3, 'dni', 55555555, 'John', 'Fixter', 1),
                         (4, 'dni', 66666666, 'Jane', 'Scott', 2),
                         (5, 'dni', 77777777, 'Pedro', 'Asnar', 3),
                         (7, 'pass', 88888888, 'Christian', 'Donnate', 3),
                         (8, 'pass', 99999999, 'Julian', 'Azkuenaga', 4),
                         (9, 'pass', 33333333, 'Peter', 'Lanzani', 4);
                         
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
insert into band_member values (1,'dni', 10101010, 'Juan', 'Salvatierra', 1, 1),
							   (2,'dni', 11101110, 'Pedro', 'Llorente', 2, 1),
                               (3,'dni', 12101210, 'Eduard', 'Steven', 4, 1),
                               (4,'pass', 15121512, 'Maria', 'Loven', 3, 1),
                               (5,'pass', 19234567, 'Elle', 'Amberson', 1, 2),
                               (6,'pass', 18101810, 'Patrik', 'Break', 3,2),
                               (7,'pass', 10151015, 'John', 'Elliot', 4,2),
                               (8,'dni', 16716716, 'Allison', 'Fogarty', 6,2),
                               (9,'dni', 14131413, 'Ashley', 'Hart', 6,5); -- Agregar másavepoint
					
#Payment
insert into payment values (1,'Credit card'),
						   (2,'Debit card'),
                           (3,'Wire transfer');
                           
#Customer
insert into customer values (1,'dni', 10000001, 'Julian', 'Schirmer', 'Lopez st. 1214', '19991027','jschirmer@mail.com'),
							(2,'dni', 10000002, 'Anna', 'Iverson', 'Made st. 1023', '19760916', 'aiverson@mail.com'),
                            (3,'pass', 50000001, 'Dana', 'klept', 'Stwart av. 455', 19860110, 'dklept@mail.com'),
                            (4,'pass', 50000002, 'Erin', 'Mooney', 'Rick st. 657', 20010321, 'emooney@mail.com'),
                            (5,'dni', 10000003, 'John', 'Landry', 'Split av. 435', 19660522, 'jlandry@mail.com'),
                            (6,'dni', 10000004, 'Pam', 'Spacey', 'Speed st. 902', 19641127, 'pspacey@gmail.com');
                            
#Concert
insert into concert values (1, '20221210','18',1);