-- v(2024.04.12)
SELECT ii.ingredient_type,sum(hf.total_order) as total_order
from first_half hf inner join icecream_info ii
on hf.flavor = ii.flavor
group by ii.ingredient_type
order by total_order;
