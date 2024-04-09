-- v(2024.04.09)
select warehouse_id,warehouse_name,address,coalesce(freezer_yn,'N') as freezer_yn
from food_warehouse
where address like '경기도%'
order by warehouse_id;