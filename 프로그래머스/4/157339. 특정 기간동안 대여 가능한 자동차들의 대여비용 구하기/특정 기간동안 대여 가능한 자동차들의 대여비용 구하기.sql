-- v(2024.06.04)
WITH FEE1 AS (
    SELECT (100-CAST(REPLACE(DISCOUNT_RATE, '%', '') AS DECIMAL))*0.01 as rate
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE like '30%' and CAR_TYPE='세단'
),
FEE2 AS (
    SELECT (100-CAST(REPLACE(DISCOUNT_RATE, '%', '') AS DECIMAL))*0.01 as rate
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE like '30%' and CAR_TYPE='SUV'
),
RentedCars AS (
    SELECT DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
   WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'
),
Cars as (
SELECT C.CAR_ID,C.CAR_TYPE,
  case when car_type='세단' then TRUNCATE(C.DAILY_FEE*(select rate from FEE1)*30,0)
  else  TRUNCATE(C.DAILY_FEE*(select rate from FEE2)*30,0)
  end as FEE
from CAR_RENTAL_COMPANY_CAR C 
where   (C.CAR_ID not in (select car_id from RentedCars)) and
(C.CAR_TYPE='SUV' or C.CAR_TYPE = '세단'))
select car_id,car_type,fee from Cars where fee>=500000 and fee<2000000 order by fee desc,car_type,car_id desc;
