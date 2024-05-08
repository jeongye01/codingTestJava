-- v(2024.05.08)
SELECT car_id,
case
when car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where '2022-10-16' between START_DATE and END_DATE) then '대여중'
else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;
