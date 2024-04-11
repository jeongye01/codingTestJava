-- v(2024.04.11)
select sum(price) as total_price
from item_info
where rarity='LEGEND';