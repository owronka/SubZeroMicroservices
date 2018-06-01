drop table A2C_MASTERDATA;
drop table A2C_PERSON;
drop table A2C_ACCOUNT;
drop table A2C_ADDRESS;

create table A2C_MASTERDATA
(
	M_ID integer auto_increment, 
	M_TYPE varchar (20) not null, 
	M_CODE varchar (20) not null, 
	M_TEXT_DE varchar (20) not null, 
	M_TEXT_EN varchar (20) not null, 
	M_VERSION integer,
	primary key (M_ID)
);
AUTO_INCREMENT = 100;

create table A2C_PERSON     
(
	P_ID integer auto_increment, 
	P_SALUTATION varchar (10), 
	P_FIRST_NAME varchar (50) not null, 
	P_LAST_NAME varchar (50) not null, 
	P_EMAIL varchar (80) not null, 
	P_VERSION integer,
	primary key (P_ID)
);
AUTO_INCREMENT = 100;

create table A2C_ACCOUNT
(
	AC_ID integer auto_increment, 
	AC_P_ID integer, 
	AC_NAME varchar (50) not null, 
	AC_PASSWORD varchar (200) not null, 
	AC_SALT varchar (40) not null,
	primary key (AC_ID)
);
AUTO_INCREMENT = 100;

create table A2C_ADDRESS
(
	AD_ID integer auto_increment, 
	AD_P_ID integer, 
	AD_TYPE varchar (20) not null, 
	AD_STREET varchar (255) not null, 
	AD_HOUSENUMBER varchar (10), 
	AD_ZIP varchar (10) not null, 
	AD_CITY varchar (255) not null, 
	AD_COUNTRY varchar (20) not null,
	primary key (AD_ID)
);
AUTO_INCREMENT = 100;

create index IDX_P_VERSION on A2C_PERSON (P_VERSION);

create unique index IDX_AC_NAME on A2C_ACCOUNT(AC_NAME);

alter table A2C_ACCOUNT add constraint CON_AC_NAME_UNIQUE UNIQUE (AC_NAME);
alter table A2C_ACCOUNT add constraint FK_AC_PI_ID foreign key (AC_P_ID) references A2C_PERSON(P_ID);
alter table A2C_ADDRESS add constraint FK_AD_P_ID  foreign key (AD_P_ID) references A2C_PERSON(P_ID);