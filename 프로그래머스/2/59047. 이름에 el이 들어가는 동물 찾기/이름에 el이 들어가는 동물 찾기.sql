-- v(2024.04.03)
SELECT animal_id,name from animal_ins
where 
animal_type="Dog" and
name like '%el%'
order by name;
