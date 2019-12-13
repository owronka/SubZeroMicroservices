create schema hbrs;
create table HBRS.Person
( 
	p_id integer, 
	anrede varchar (20),
	vorname varchar (20), 
	nachname varchar (30), 
	email varchar (40),
	telefon integer,
	primary key (p_id)
); 

create table HBRS.Account
( 
	ac_id integer,
	nickname varchar (30),
	password varchar (30),
	primary key (ac_id)
);

create table HBRS.Address
(
	address_id integer,
	stadt varchar (20),
	land varchar (20),
	strasse varchar (30),
	hausnummer integer,
	plz integer,
	primary key (address_id)
);

alter table HBRS.Account 
add constraint fk_ac_id foreign key (ac_id) references HBRS.Person (p_id);

alter table HBRS.Address 
add constraint fk_a_id foreign key (address_id) references HBRS.Person (p_id);




Insert into HBRS.PERSON
values(1, 'Frau', 'Nithu', 'Indran','test@test.de', 0123456789);
Insert into HBRS.PERSON
values(2, 'Frau', 'Indu', 'Indran','test2@test.de', 1234567890);
Insert into HBRS.ACCOUNT
values(2, 'nindra2s', '1234NI');

