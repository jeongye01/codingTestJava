-- V(2024.04.11)
SELECT b.category,sum(s.sales) as total_sales 
from book_sales s
inner join book b
on s.book_id = b.book_id 
where year(s.sales_date) = 2022 and month(s.sales_date) =1
group by b.category
order by b.category;