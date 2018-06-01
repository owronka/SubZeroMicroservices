create table app.adresse(
	id integer NOT NULL,
	land varchar(3),
	plz varchar(10),
	ort varchar(50),
	strasse varchar(50),
	hausnummer varchar(6),
	person integer,
	PRIMARY KEY (id)
);

create table app.person(
	id integer NOT NULL,
	anrede varchar(5),
	vorname varchar(20),
	nachname varchar(40),
	PRIMARY KEY (id)
);

create table app.account(
	id integer NOT NULL,
	email varchar(40),
	benutzer varchar(15),
	passwort varchar(20),
	person integer,
	PRIMARY KEY (id)
);


ALTER TABLE APP.adresse ADD FOREIGN KEY (person) REFERENCES APP.person(id);
ALTER TABLE APP.account ADD FOREIGN KEY (person) REFERENCES APP.person(id);

create sequence ACCOUNT_ID as integer start with 100;
create sequence ADDRESS_ID as integer start with 100;
create sequence PERSON_ID  as integer start with 100;
