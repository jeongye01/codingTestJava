-- v(2024.06.17)
with A_GROUP as (
    select 'A' as GRADE, ID, EMAIL
    from DEVELOPERS
    where SKILL_CODE & (select code from skillcodes where name='Python') 
    and exists (
        select CODE from skillcodes where CATEGORY='Front End' and (SKILL_CODE & CODE = CODE)
    )
),
B_GROUP as (
    select 'B' as GRADE, ID, EMAIL
    from DEVELOPERS 
    where SKILL_CODE & (select code from skillcodes where name='C#') and ID not in (select ID from A_GROUP)
),
C_GROUP as (
    select 'C' as GRADE, ID, EMAIL
    from DEVELOPERS
    where exists (
        select CODE from skillcodes where CATEGORY='Front End' and (SKILL_CODE & CODE = CODE)
    )
    and ID not in (select ID from A_GROUP) and ID not in (select ID from B_GROUP)
),
Result as (
  select * from A_GROUP
union
select * from B_GROUP
union 
select * from C_GROUP
)

select * from Result order by GRADE,ID;






# select 
#   case 
#     when  
#   as GRADE,ID,EMAIL
# from DEVELOPERS D join SKILLCODES S on 