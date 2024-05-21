-- v(2024.05.21)
SELECT a.AUTHOR_ID,a.AUTHOR_NAME,b.CATEGORY,sum(s.sales*b.price)
from  book b 
join author a on b.author_id = a.author_id
join book_sales s on b.book_id = s.book_id
where s.sales_date like '2022-01%'
group by b.author_id,b.category
order by a.author_id,b.category desc;
