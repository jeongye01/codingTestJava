-- v(2024.04.11)
SELECT ai.name,ai.datetime
from animal_ins ai
left join animal_outs ao
on ai.animal_id = ao.animal_id
where ao.datetime is null
order by ai.datetime
limit 3;
