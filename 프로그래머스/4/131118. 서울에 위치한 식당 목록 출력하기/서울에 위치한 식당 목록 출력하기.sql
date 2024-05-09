-- v(2024.05.09)
SELECT ri.REST_ID,ri.REST_NAME,ri.FOOD_TYPE,ri.FAVORITES,ri.ADDRESS,
round(AVG(rr.REVIEW_SCORE),2) as SCORE
from REST_INFO ri join REST_REVIEW rr
on ri.REST_ID = rr.REST_ID
where ri.address like '서울%'
group by ri.REST_ID
order by score desc,ri.FAVORITES desc;