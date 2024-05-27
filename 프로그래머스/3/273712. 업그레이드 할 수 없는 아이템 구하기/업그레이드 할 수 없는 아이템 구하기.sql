-- v(2024.05.27)
select I.ITEM_ID,I.ITEM_NAME,I.RARITY
from  ITEM_INFO I left join ITEM_TREE T
on I.item_id = T.PARENT_ITEM_ID
where T.PARENT_ITEM_ID is null
order by I.ITEM_ID desc;