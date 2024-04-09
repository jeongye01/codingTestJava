-- V(2024.04.09)
select count(*) as users
from user_info
where joined like '2021%' and age between 20 and 29;