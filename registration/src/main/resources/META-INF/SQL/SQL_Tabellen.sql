

create table HBRS.Person
( 
	P_ID integer, 
	Vorname varchar (20), 
	Nachname varchar (30), 
	Firma varchar (30),
	Email varchar (40),
	Telefon integer,
	primary key (P_ID)
) 

create table HBRS.Account
( 
	AC_ID integer,
	PASSWORD varchar (30),
	primary key (AC_ID)

)

create table HBRS.Adress
(
	Adress_ID integer,
	Stadt varchar (20),
	Land varchar (20),
	Straße varchar (30),
	Hausnummer integer,
	PLZ integer,
	primary key (Adress_ID)
)

