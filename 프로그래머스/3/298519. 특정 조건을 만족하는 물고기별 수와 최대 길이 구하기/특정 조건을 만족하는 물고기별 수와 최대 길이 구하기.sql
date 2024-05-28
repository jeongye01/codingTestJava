-- v(2024.05.28)
select count(*) as FISH_COUNT, max(length) as MAX_LENGTH,FISH_TYPE
from FISH_INFO
group by FISH_TYPE
having avg(coalesce(length,10))>=33
order by fish_type;