-- v(2024.05.09)
select id, 
case
  when SIZE_OF_COLONY <= 100 then 'LOW'
  when SIZE_OF_COLONY <= 1000 then 'MEDIUM'
  else 'HIGH'
end as size
from ECOLI_DATA
order by id;