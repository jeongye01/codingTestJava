-- v(2024.05.09)
select he.DEPT_ID,hd.DEPT_NAME_EN,round(AVG(he.SAL)) as  AVG_SAL
from HR_DEPARTMENT hd join HR_EMPLOYEES he
on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by AVG_SAL desc;