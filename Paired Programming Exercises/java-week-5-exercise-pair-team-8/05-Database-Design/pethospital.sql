Begin transaction;  -- start of the Unit of Work

drop table if exists pet     cascade;  -- delete any existing tables and their dependents from the databases
drop table if exists owner   cascade;  -- if cascade is omitted - dependents must be dropped befor parents
drop table if exists procedure cascade;
drop table if exists visit     cascade;


create table pet (
 pet_id     serial        not null      
,name       varchar(30)   not null
,species    varchar(12)   not null   
,pet_age    int           not null    default 0
,constraint pk_pet_petID primary key (pet_id)
);

create table owner (
owner_id     serial        not null
,first_name  varchar(25)   not null
,last_name   varchar(25)   not null 
,address     varchar(50)   not null
,constraint pk_owner_ownerID primary key (owner_id)
);

create table owner_pet (
pet_id       serial        not null
,owner_id    serial        not null
,constraint pk_owner_pet_ownerpet primary key (pet_id, owner_id)
);

create table procedure (
procedure_id smallserial   not null
,total        money        not null    default 0
,name        varchar(30)   not null
,tax         float         not null     default .08
,constraint pk_procedure_procedureID primary key (procedure_id)
);

create table procedure_visit (
procedure_id  serial       not null
,visit_id     serial       not null
,constraint pk_procedure_visit_procedureID primary key (procedure_id, visit_id)
);

create table visit (
visit_id      serial       not null
,date_stamp   date         not null
,procedure_id serial       not null
,owner_id     serial       not null
,constraint pk_visit_visit_id primary key (visit_id)
);

Insert into pet
(pet_id, name, species, pet_age)
Values(0001, 'Rover', 'Dog', 12);
Insert into pet
(pet_id, name, species, pet_age)
Values(0002, 'Spot', 'Dog', 2);
Insert into pet
(pet_id, name, species, pet_age)
Values(0003, 'Morris', 'Cat', 4);
Insert into pet
(pet_id, name, species, pet_age)
Values(0004, 'Tweedy', 'Bird', 2);
Insert into pet
(pet_id, name, species, pet_age)
Values(0005, 'Homer', 'Dog', 6);
Insert into pet
(pet_id, name, species, pet_age)
Values(0006, 'Benny', 'Dog', 2);
Insert into pet
(pet_id, name, species, pet_age)
Values(0007, 'Azzy', 'Cat', 10);
Insert into pet
(pet_id, name, species, pet_age)
Values(0008, 'Boo', 'Ferret', 1);

Insert into owner
(owner_id, first_name, last_name, address)
Values(0001, 'Sam', 'Cook', '123 Fake St');
Insert into owner
(owner_id, first_name, last_name, address)
Values(0002, 'Terry', 'Kim', '234 Fake St');
Insert into owner
(owner_id, first_name, last_name, address)
Values(0003, 'Jesus H', 'Christ', 'Heaven lol');
Insert into owner
(owner_id, first_name, last_name, address)
Values(0004, 'Mohammed', 'Mohammed', '1600 Pennsylvania Ave');

Insert into owner_pet
(owner_id, pet_id)
Values (0001, 0001);
Insert into owner_pet
(owner_id, pet_id)
Values (0001, 0003);
Insert into owner_pet
(owner_id, pet_id)
Values (0002, 0002);
Insert into owner_pet
(owner_id, pet_id)
Values (0002, 0004);
Insert into owner_pet
(owner_id, pet_id)
Values (0003, 0008);
Insert into owner_pet
(owner_id, pet_id)
Values (0003, 0006);
Insert into owner_pet
(owner_id, pet_id)
Values (0004, 0007);
Insert into owner_pet
(owner_id, pet_id)
Values (0004, 0005);

Insert into procedure
(procedure_id, total, name)
Values(01, 5.00, 'Rabies Vaccination');
Insert into procedure
(procedure_id, total, name)
Values(10, 10.00, 'Examine and Treat Wound');
Insert into procedure
(procedure_id, total, name)
Values(05, 7.00, 'Heart Worm Test');
Insert into procedure
(procedure_id, total, name)
Values(08, 3.00, 'Tetanus Vaccination');
Insert into procedure
(procedure_id, total, name)
Values(69, 20.00, 'Euthanasia');
Insert into procedure
(procedure_id, total, name)
Values(20, 15.00, 'Annual Check Up');
Insert into procedure
(procedure_id, total, name)
Values(12, 1.00, 'Eye Wash');

Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0420, '2020-02-14', 01, 0003);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0416, '2020-02-14', 12, 0003);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0419, '2020-02-14', 01, 0001);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0415, '2020-02-14', 10, 0001);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0414, '2020-02-14', 05, 0001);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0418, '2020-02-14', 20, 0004);
Insert into visit
(visit_id, date_stamp, procedure_id, owner_id)
Values(0417, '2020-02-14', 05, 0002);

Insert into procedure_visit
(procedure_id, visit_id)
Values(01, 0420);
Insert into procedure_visit
(procedure_id, visit_id)
Values(12, 0416);
Insert into procedure_visit
(procedure_id, visit_id)
Values(01, 0415);
Insert into procedure_visit
(procedure_id, visit_id)
Values(10, 0414);
Insert into procedure_visit
(procedure_id, visit_id)
Values(20, 0418);
Insert into procedure_visit
(procedure_id, visit_id)
Values(05, 0417);

alter table owner_pet       add foreign key(owner_id)     references owner(owner_id);
alter table owner_pet       add foreign key(pet_id)       references pet(pet_id);
alter table visit           add foreign key(procedure_id) references procedure(procedure_id);
alter table procedure_visit add foreign key(procedure_id) references procedure(procedure_id);
alter table procedure_visit add foreign key(visit_id)     references visit(visit_id);
alter table visit           add foreign key(owner_id)     references owner(owner_id);

commit;