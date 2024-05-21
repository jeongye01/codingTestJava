-- v(2024.05.21)
SELECT * from PLACES
where host_id in ( 
    select host_id from places group by host_id having count(*) >=2 
)
order by id;