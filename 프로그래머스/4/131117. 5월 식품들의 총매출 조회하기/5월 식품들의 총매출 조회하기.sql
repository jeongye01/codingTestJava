-- 2024.05.02
SELECT fp.product_id,fp.product_name,sum(fp.price*fo.amount) as total_sales
from food_product fp 
inner join food_order fo
on fp.product_id = fo.product_id
where fo.produce_date between '2022-05-01' and  '2022-05-31'
group by fp.product_name
order by total_sales desc,fp.product_id;