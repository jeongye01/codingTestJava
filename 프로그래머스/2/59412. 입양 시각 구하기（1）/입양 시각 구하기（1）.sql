-- v(2024.04.10)
SELECT hour(datetime) as hour,count(*) as count 
from animal_outs
group by hour
having hour  between 9 and 19
order by hour;