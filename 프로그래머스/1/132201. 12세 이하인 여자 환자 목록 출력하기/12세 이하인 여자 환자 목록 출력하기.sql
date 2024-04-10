-- v(2024.04.09)
select pt_name,pt_no,gend_cd,age,coalesce(tlno,'NONE') as tlno
from patient
where age<=12 and gend_cd="W"
order by age desc,pt_name;