
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

create table HBRS.Adress
(
	adress_id integer,
	stadt varchar (20),
	land varchar (20),
	straße varchar (30),
	hausnummer integer,
	plz integer,
	primary key (adress_id)
);

alter table HBRS.Account 
add constraint fk_ac_id foreign key (ac_id) references HBRS.Person (p_id);

alter table HBRS.Adress 
add constraint fk_a_id foreign key (adress_id) references HBRS.Person (p_id);