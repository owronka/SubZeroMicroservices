insert into A2C_MASTERDATA values (1, 'SALUTATION', 'CMPNY', 'Firma', 'Company', 1);
insert into A2C_MASTERDATA values (2, 'SALUTATION', 'MRS',   'Frau',  'Mrs',     1);
insert into A2C_MASTERDATA values (3, 'SALUTATION', 'MR',    'Herr',  'Mr',      1);

insert into A2C_MASTERDATA values (11, 'COUNTRY', 'DE', 'Deutschland', 'Germany', 1);
insert into A2C_MASTERDATA values (12, 'COUNTRY', 'EN', 'England',     'England', 1);
insert into A2C_MASTERDATA values (13, 'COUNTRY', 'SP', 'Spanien',     'Spain',   1);

insert into A2C_MASTERDATA values (21, 'ADDRESS', 'HOME',   'Zuhause',  'home',   1);
insert into A2C_MASTERDATA values (22, 'ADDRESS', 'OFFICE', 'Büro',     'office', 1);


insert into A2C_PERSON values (1, 'MR', 'Achim',   'Admin',   'admin@axxessio.com',   1);
insert into A2C_PERSON values (2, 'MR', 'Manfred', 'Manager', 'manager@axxessio.com', 2);
insert into A2C_PERSON values (3, 'MR', 'Udo',     'User',    'user@axxessio.com',    3);

-- user / password : admin / axxessio
insert into A2C_ACCOUNT values (1, 1, 'admin',   'c021b83506b4a28acb469077587d06566fb3e36f91518699afcb9832f5983bed931cacce9538ac5642aab1ead67e7fbe', '8d19e652a8421220d67ebaee0865413e');
-- user / password : manager / axxessio
insert into A2C_ACCOUNT values (2, 2, 'manager', '99c661c05b6e11623494a5ae6441393a0a3e7a87c283ddc1f4cc2d94ac14813d9d815b7de0de8b564fc17490ddcc2b1e', 'bcb314a2e508fffd14ef90a46ee535bb');
-- user / password :user /user
insert into A2C_ACCOUNT values (3, 3, 'user',    'cdcd9114631f0d8024661dd5640771836331a345404f29e67733928229e354b1cfc10600178e855e4da3c4ae1b83f250', 'd5451004e416691d14862ea1981fe4b2');

insert into A2C_ADDRESS values (1, 1, 'HOME',   'AdminHomeStreet',     '11', '11111', 'AdminCity',   'DE');  
insert into A2C_ADDRESS values (2, 2, 'OFFICE', 'ManagerOfficeStreet', '21', '21212', 'ManagerCity', 'DE');  
insert into A2C_ADDRESS values (3, 3, 'HOME',   'UserHomeStreet',      '31', '31313', 'UserCity',    'DE');  
insert into A2C_ADDRESS values (4, 3, 'OFFICE', 'UserOfficeStreet',    '32', '32323', 'UserCity',    'DE');  
