-- v(2024.04.09)
SELECT animal_type,coalesce(name,'No name') as name,sex_upon_intake
from animal_ins
order by animal_id;