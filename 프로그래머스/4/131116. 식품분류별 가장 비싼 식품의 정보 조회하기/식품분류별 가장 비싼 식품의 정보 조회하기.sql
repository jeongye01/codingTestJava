-- v(2024.04.19)
SELECT category,price,product_name
from food_product
where price in (select max(price) from food_product group by category) and category in ('식용유','국','과자','김치')
order by price desc;