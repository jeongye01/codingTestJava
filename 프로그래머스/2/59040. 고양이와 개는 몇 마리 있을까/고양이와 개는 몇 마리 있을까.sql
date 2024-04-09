-- v(2024.04.09)
SELECT ANIMAL_TYPE,count(*) as count
from animal_ins
group by animal_type
order by animal_type;