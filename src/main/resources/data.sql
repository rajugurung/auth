insert into USER(ID, PASSWORD, USERNAME) values(1, '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'raju@gmail.com');

insert into ROLE(ID, ROLE) values(1, 'ADMIN');
insert into USER_ROLE(ID,USER_ID,ROLE_ID) values (1,1,1);