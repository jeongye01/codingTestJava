-- v(2024.06.12)
select year(O.sales_date) as YEAR,month(O.sales_date) as MONTH, count(distinct U.user_id) as PURCHASED_USERS,

round(count(distinct U.user_id)/(select count(*) from USER_INFO where year(joined) = 2021),1)as PUCHASED_RATIO
from USER_INFO U join ONLINE_SALE O on U.user_id = O.user_id
where year(U.JOINED) = 2021
group by YEAR,MONTH
order by  YEAR,MONTH;