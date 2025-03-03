insert into USER_DETAILS (id, BIRTH_DATE, name)
values (10001, DATEADD(YEAR, -23, current_date), 'Samah');

insert into USER_DETAILS (id, BIRTH_DATE, name)
values (10002, DATEADD(YEAR, -33, current_date), 'Ali');

insert into USER_DETAILS (id, BIRTH_DATE, name)
values (10003, DATEADD(YEAR, -43, current_date), 'Maha');

insert into post(id, description, user_id)
values(20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values(20002, 'I want to learn DevOps', 10001);

insert into post(id, description, user_id)
values(20003, 'I want to learn Java', 10002);

insert into post(id, description, user_id)
values(20004, 'I want to learn Multi cloud', 10002);
