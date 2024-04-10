-- 코드를 입력하세요
SELECT mcdp_cd as 진료과코드,count(*) 5월예약건수
from appointment
where year(apnt_ymd) = 2022 AND month(apnt_ymd) = 5
group by mcdp_cd
order by count(*),mcdp_cd;