-- v(2024.04.12)
SELECT ao.animal_id,ao.animal_type,ao.name
from animal_ins ai inner join animal_outs ao
on ai.animal_id = ao.animal_id
where ai.sex_upon_intake like 'Intact%' and (ao.sex_upon_outcome like 'Spayed%' or ao.sex_upon_outcome like 'Neutered%')
order by ao.animal_id; 