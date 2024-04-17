-- v(2024.04.17)
SELECT distinct(crcr.car_id)
from CAR_RENTAL_COMPANY_CAR crcr 
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
on crcr.car_id = crcrh.car_id
where crcr.car_type='세단' and crcrh.start_date between '2022-10-01'  and '2022-10-31'
order by crcr.car_id desc;
