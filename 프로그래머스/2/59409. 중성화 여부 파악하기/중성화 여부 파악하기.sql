-- v(2024.04.10)
SELECT animal_id,name,
  CASE 
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END as 중성화
from animal_ins
order by animal_id;