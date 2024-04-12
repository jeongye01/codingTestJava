-- v(2024.04.12)
SELECT b.book_id,a.author_name, date_format(b.published_date,'%Y-%m-%d') as published_date
from book b inner join author a
on b.author_id = a.author_id
where b.category='경제'
order by b.published_date;