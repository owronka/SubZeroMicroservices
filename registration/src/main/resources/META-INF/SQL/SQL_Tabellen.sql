
create table HBRS.Person
( 
	p_id integer, 
	anrede varchar (20),
	vorname varchar (20), 
	nachname varchar (30), 
	firma varchar (30),
	email varchar (40),
	telefon integer,
	primary key (p_id)
); 

create table HBRS.Account
( 
	ac_id integer,
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