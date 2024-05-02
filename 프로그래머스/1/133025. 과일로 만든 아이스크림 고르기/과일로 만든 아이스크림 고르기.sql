-- 2024.05.02
select fh.flavor
from first_half fh inner join icecream_info ii
on fh.flavor = ii.flavor
where fh.total_order >3000 and ii.ingredient_type = 'fruit_based'
order by fh.total_order desc;