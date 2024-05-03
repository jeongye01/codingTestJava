-- v(2024.05.03)
SELECT ao.animal_id,ao.name
from animal_ins ai 
right join animal_outs ao
on ai.animal_id = ao.animal_id
where ai.datetime is null
order by ai.animal_id,ai.name;
