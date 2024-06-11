-- v(2024.06.11)

select ID,EMAIL,FIRST_NAME,LAST_NAME
from DEVELOPERS 
where exists (select CODE from SKILLCODES where CATEGORY='Front End' and (CODE & SKILL_CODE))
order by id;