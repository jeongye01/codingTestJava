-- v(2024.05.27)
select E.EMP_NO,E.EMP_NAME,
  case 
    when avg(G.score) >= 96 then 'S'
    when avg(G.score) >= 90 then 'A'
    when avg(G.score) >= 80 then 'B'
    else 'C'
  end as GRADE,
   case 
    when avg(G.score) >= 96 then E.SAL * 0.2
    when avg(G.score) >= 90 then E.SAL * 0.15
    when avg(G.score) >= 80 then E.SAL * 0.1
    else 0
  end as BONUS
from HR_EMPLOYEES E join HR_GRADE G on E.EMP_NO = G.EMP_NO
group by E.EMP_NO,G.YEAR
order by E.EMP_NO;

