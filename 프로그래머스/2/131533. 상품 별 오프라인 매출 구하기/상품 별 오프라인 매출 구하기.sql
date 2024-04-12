-- v(2024.04.12)
SELECT p.product_code,p.price * sum(os.sales_amount) as sales 
from product p inner join offline_sale os
on p.product_id = os.product_id
group by product_code
order by sales desc,p.product_code;
