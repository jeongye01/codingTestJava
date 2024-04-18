-- v(2024.04.18)
SELECT u.user_id,u.nickname,sum(b.price) as total_price
from used_goods_board b inner join used_goods_user u
on b.writer_id = u.user_id
where b.status = 'DONE'
group by u.user_id
having total_price>=700000
order by total_price;

