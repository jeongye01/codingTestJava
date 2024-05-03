-- v(2024.05.02)
SELECT u.user_id,u.nickname,
concat(u.city,' ',u.street_address1,' ',u.street_address2) as 전체주소,
CONCAT(SUBSTR(u.tlno, 1, 3), '-', SUBSTR(u.tlno, 4, 4), '-', SUBSTR(u.tlno, 8)) as 전화번호
from USED_GOODS_BOARD b 
inner join used_goods_user u
on b.writer_id = u.user_id
group by u.user_id
having count(*)>=3
order by u.user_id desc;