-- v(2024.05.13)
select count(*) as fish_count, substr(time,6,2)+0 as MONTH
from FISH_INFO
group by month
order by month;
