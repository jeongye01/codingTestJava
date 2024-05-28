-- v(2024.05.28)
select I.ITEM_ID,I.ITEM_NAME,I.RARITY
from ITEM_INFO I join ITEM_TREE T on I.ITEM_ID = T.ITEM_ID
where T.PARENT_ITEM_ID in (select ITEM_ID from ITEM_INFO where RARITY='RARE')
order by I.item_id desc;
