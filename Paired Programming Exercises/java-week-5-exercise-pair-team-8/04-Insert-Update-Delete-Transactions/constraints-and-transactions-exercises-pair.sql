-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
--Begin transaction;
insert into city
(name, countrycode, district, population)
values('Smallville', 'USA', 'Kansas', 45001)
;

select * from city where name = 'Smallville';
--rollback;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
insert into countrylanguage
(countrycode, language, isofficial, percentage)
values('USA', 'Kryptonese', true, 0.0001)
;
select * from countrylanguage where countrycode = 'USA';

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
--Begin transaction;
update countrylanguage
 set language = 'Krypto-babble'
 where language = 'Kryptonese'
;
select * from countrylanguage where countrycode = 'USA';

-- 4. Set the US capital to Smallville, Kansas in the country table.
--Begin transaction;
update country
set capital = (select id from city where name = 'Smallville')
where code = 'USA'
;
select name, capital from country where code = 'USA'
;

--rollback;

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
delete from city
where name = 'Smallville'
;

select * from city where name = 'Smallville';
-- No, because Smallville is currently the capital of the USA so it creates an error.

-- 6. Return the US capital to Washington.
update country
set capital = (select id from city where name = 'Washington')
where code = 'USA'
;
select name, capital from country where code = 'USA'
;

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
delete from city
where name = 'Smallville'
;

select * from city where name = 'Smallville';
-- Yes, because the other table is no longer dependent upon it.

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
update countrylanguage
set isofficial = not countrylanguage.isofficial
from countrylanguage c
join country on country.code = c.countrycode
and indepyear between 1800 and 1972
;

select language, isofficial, countrycode
from countrylanguage
;

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
Begin transaction;
update city
set population = round(population/1000)
where population !=0
;
select name,population
from city
;
rollback;

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
Begin transaction;
update country
set surfacearea = surfacearea * 2589988.1103
where code in (select countrycode from countrylanguage where language = 'French' and percentage > 20)
;

rollback;
