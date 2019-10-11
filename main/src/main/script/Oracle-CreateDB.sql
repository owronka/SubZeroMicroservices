drop table if exists A2O_ROLERIGHT;
drop table if exists A2O_USERROLE;
drop table if exists A2O_RIGHT;
drop table if exists A2O_ROLE;
drop table if exists A2O_USER;
drop table if exists A2O_ACCESS_TOKEN;

CREATE TABLE A2O_RIGHT
(
  RI_ID         INT          PRIMARY KEY,
  RI_NAME       VARCHAR (20) NOT NULL,
  RI_SCOPE      VARCHAR (20) NOT NULL,
  RI_RIGHT      VARCHAR (1)  NOT NULL,
);

insert into A2O_RIGHT values (11, 'CREATE_CUSTOMER', 'CUSTOMER', 'C');
insert into A2O_RIGHT values (12, 'READ_CUSTOMER',   'CUSTOMER', 'R');
insert into A2O_RIGHT values (13, 'UPDATE_CUSTOMER', 'CUSTOMER', 'U');
insert into A2O_RIGHT values (14, 'DELETE_CUSTOMER', 'CUSTOMER', 'D');
insert into A2O_RIGHT values (21, 'CREATE_ORDER',    'ORDER',    'C');
insert into A2O_RIGHT values (22, 'READ_ORDER',      'ORDER',    'R');
insert into A2O_RIGHT values (23, 'UPDATE_ORDER',    'ORDER',    'U');
insert into A2O_RIGHT values (24, 'DELETE_ORDER',    'ORDER',    'D');

CREATE TABLE A2O_ROLE
(
  RO_ID    INT          PRIMARY KEY,
  RO_NAME  VARCHAR (20) NOT NULL
);

insert into A2O_ROLE values (1, 'ADMIN');
insert into A2O_ROLE values (2, 'MANAGER');
insert into A2O_ROLE values (3, 'USER');
insert into A2O_ROLE values (4, 'GUEST');

CREATE TABLE A2O_USER
(
  U_ID            INT           PRIMARY KEY,
  U_NAME          VARCHAR (50)  NOT NULL,
  U_EMAIL         VARCHAR (80)  NOT NULL,
  U_FIRST_NAME    VARCHAR (50)  NOT NULL,
  U_LAST_NAME     VARCHAR (50)  NOT NULL,
  U_PASSWORD      VARCHAR (200) NOT NULL,
  U_SALT          VARCHAR (40)  NOT NULL,
  CONSTRAINT USER_PK PRIMARY KEY (U_ID)
);

insert into A2O_USER values (1, 'admin',   'admin@axxessio.com',   'Achim',   'Admin',   'c021b83506b4a28acb469077587d06566fb3e36f91518699afcb9832f5983bed931cacce9538ac5642aab1ead67e7fbe', '8d19e652a8421220d67ebaee0865413e');
insert into A2O_USER values (2, 'manager', 'manager@axxessio.com', 'Manfred', 'Manager', '99c661c05b6e11623494a5ae6441393a0a3e7a87c283ddc1f4cc2d94ac14813d9d815b7de0de8b564fc17490ddcc2b1e', 'bcb314a2e508fffd14ef90a46ee535bb');
insert into A2O_USER values (3, 'user',    'user@axxessio.com',    'Udo',     'User',    '94cd1aa9feee290304ed37d8edc020ab0204d39786b51e3db9993ab4364454d9fd0c99116890fa593ce0820fe446091a', 'd5451004e416691d14862ea1981fe4b2');
 
CREATE TABLE A2O_ROLERIGHT
(
  RR_RO_ID  INTEGER NOT NULL,
  RR_RI_ID  INTEGER NOT NULL
);

insert into A2O_ROLERIGHT values (1, 11);
insert into A2O_ROLERIGHT values (1, 12);
insert into A2O_ROLERIGHT values (1, 13);
insert into A2O_ROLERIGHT values (1, 14);
insert into A2O_ROLERIGHT values (1, 21);
insert into A2O_ROLERIGHT values (1, 22);
insert into A2O_ROLERIGHT values (1, 23);
insert into A2O_ROLERIGHT values (1, 24);
insert into A2O_ROLERIGHT values (2, 11);
insert into A2O_ROLERIGHT values (2, 12);
insert into A2O_ROLERIGHT values (2, 13);
insert into A2O_ROLERIGHT values (2, 21);
insert into A2O_ROLERIGHT values (2, 22);
insert into A2O_ROLERIGHT values (2, 23);
insert into A2O_ROLERIGHT values (3, 12);
insert into A2O_ROLERIGHT values (3, 22);

CREATE TABLE A2O_USERROLE
(
  UR_U_ID   NUMBER NOT NULL,
  UR_RO_ID  NUMBER NOT NULL
);

insert into A2O_USERROLE values (1, 1);
insert into A2O_USERROLE values (2, 2);
insert into A2O_USERROLE values (3, 3);

CREATE TABLE A2O_ACCESS_TOKEN ( 
  AT_ID             INT             PRIMARY KEY,
  AT_ACCESS_TOKEN 	VARCHAR (255)	NOT NULL,
  AT_TOKEN_TYPE 	VARCHAR (10)	NOT NULL,
  AT_EXPIRES_IN 	INT				NOT NULL,
  AT_REFRESH_TOKEN 	VARCHAR (255)	NOT NULL,
  AT_SESSION_ID 	VARCHAR (255)	NOT NULL,
  AT_CREATED_AT 	TIMESTAMP       NOT NULL,
  AT_USER           VARCHAR (50)    NOT NULL
);
