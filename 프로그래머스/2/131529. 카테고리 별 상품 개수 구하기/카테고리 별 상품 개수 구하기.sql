-- V(2024.04.09)
select substr(product_code, 1, 2) as category, count(*) as products
from product
group by category
order by category;