-- v(2024.06.04)
select ID,EMAIL,FIRST_NAME,LAST_NAME from DEVELOPERS
where SKILL_CODE & (select code from SKILLCODES where name='C#') or SKILL_CODE & (select code from SKILLCODES where name='Python') order by ID;