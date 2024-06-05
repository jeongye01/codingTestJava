-- v(2024.06.05)
with big as (
   select max(SIZE_OF_COLONY) as size,year(DIFFERENTIATION_DATE) as year
   from ECOLI_DATA
   group by year
)


select year(E.DIFFERENTIATION_DATE) as YEAR,(big.size-E.SIZE_OF_COLONY) as YEAR_DEV,E.id
from ECOLI_DATA E join big on YEAR(E.DIFFERENTIATION_DATE) = big.year
order by YEAR,YEAR_DEV;

