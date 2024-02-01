-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(start_date,'%Y-%m-%d') as START_DATE,DATE_FORMAT(end_date,'%Y-%m-%d') as END_DATE, CASE WHEN DATEDIFF(END_DATE,START_DATE) + 1 >= 30 THEN "장기 대여" ELSE "단기 대여" END AS RENT_TYPE
from car_rental_company_rental_history
WHERE  START_DATE BETWEEN '2022-09-01' AND '2022-09-30'
ORDER BY  HISTORY_ID DESC