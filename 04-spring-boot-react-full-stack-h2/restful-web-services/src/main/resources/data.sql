/* USERS ------------------------------------------------------> */

/*https://www.browserling.com/tools/bcrypt Use Rounds 10*/

/*in28minutes/dummy*/
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) 
VALUES (1, 'in28minutes', '$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e','ROLE_USER');

/*gourab/password*/
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) 
VALUES (2, 'gourab', '$2a$10$fTanNcoaUWY3UHgz5sAaX.L5rHWzvpNCppLz43qkvQekh/MwPVN3.','ROLE_USER');


/* TODO DATA ---------------------------------------------------> */

insert into todo(id, username,description,target_date,is_done)
values(10001, 'in28minutes', 'Learn JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10002, 'in28minutes', 'Learn Data JPA', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(10003, 'in28minutes', 'Learn Microservices', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(20001, 'gourab', 'Spend time with family', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(20002, 'gourab', 'Learn Docker', sysdate(), false);

insert into todo(id, username,description,target_date,is_done)
values(20003, 'gourab', 'Learn Microservices', sysdate(), false);
