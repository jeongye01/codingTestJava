-- v(2024.04.09)
select dr_name,dr_id,mcdp_cd,date_format(hire_ymd,'%Y-%m-%d')as hire_ymd
from doctor
where mcdp_cd = 'cs' or mcdp_cd ='gs'
order by hire_ymd desc, dr_name;
