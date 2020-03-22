



Select site_id from site where site_id in (select site_id from reservation where from_date <= '2020-02-18')
                           and site_id in (select site_id from reservation where to_date <= '2020-02-22' and to_date >= '2020-02-18')
                           or
                          site_id in (select site_id from reservation where from_date >= '2020-02-18' and from_date <= '2020-02-22')
                           and site_id in (select site_id from reservation where to_date >= '2020-02-22')    
                           or 
                          site_id in (select site_id from reservation where from_date >= '2020-02-18'and from_date <= '2020-02-22')
                           and site_id in (select site_id from reservation where to_date <= '2020-02-22' and to_date >= '2020-02-18')
                           
                           
          ----------                 
                           
                           
Select site_id from site where campground_id = 1 and site_id not in (select site_id where site_id in (select site_id from reservation where from_date <= '2020-02-18')
                           and site_id in (select site_id from reservation where to_date <= '2020-02-22' and to_date >= '2020-02-18')
                           or
                          site_id in (select site_id from reservation where from_date >= '2020-02-18' and from_date <= '2020-02-22')
                           and site_id in (select site_id from reservation where to_date >= '2020-02-22')    
                           or 
                          site_id in (select site_id from reservation where from_date >= '2020-02-18'and from_date <= '2020-02-22')
                           and site_id in (select site_id from reservation where to_date <= '2020-02-22' and to_date >= '2020-02-18'))                           
                      limit 5;

--------------


Select site_id from site where site_id not in (select site_id where site_id in (select site_id from reservation where from_date < '2020-02-18')
                           and site_id in (select site_id from reservation where to_date < '2020-02-22' and to_date > '2020-02-18')
                           or
                          site_id in (select site_id from reservation where from_date > '2020-02-18' and from_date < '2020-02-22')
                           and site_id in (select site_id from reservation where to_date > '2020-02-22')    
                           or 
                          site_id in (select site_id from reservation where from_date > '2020-02-18'and from_date < '2020-02-22')
                           and site_id in (select site_id from reservation where to_date < '2020-02-22' and to_date > '2020-02-18'))
                           
          
                                 
SELECT nextval('seq_reservation_id') from reservation;