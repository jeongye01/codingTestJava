-- v(2024.05.23)
select 
case 
when substr(DIFFERENTIATION_DATE,6,2) between 1 and 3 then '1Q'
when substr(DIFFERENTIATION_DATE,6,2) between 4 and 6 then '2Q'
when substr(DIFFERENTIATION_DATE,6,2) between 7 and 9 then '3Q'
else '4Q'
end as QUARTER,
count(*) as ECOLI_COUNT
from ECOLI_DATA
group by QUARTER
order by  QUARTER;