-- v(2024.04.13)
SELECT ai.animal_id,ai.name
from animal_ins ai inner join animal_outs ao
on ai.animal_id = ao.animal_id
order by ao.datetime - ai.datetime desc
limit 2;
