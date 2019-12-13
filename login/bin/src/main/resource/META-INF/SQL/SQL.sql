create table user
(
	AC_ID integer, 
	AC_P_ID integer, 
	AC_NAME varchar (20) not null, 
	AC_PASSWORD varchar (30) not null, 
	AC_SALT varchar (40) not null,
	primary key (AC_ID)
) 

