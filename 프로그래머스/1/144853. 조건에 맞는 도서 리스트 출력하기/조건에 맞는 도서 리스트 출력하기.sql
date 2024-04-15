-- v(2024.04.15)
select book_id,date_format(published_date,'%Y-%m-%d') as published_date
from book
where published_date between '2021-01-01' and '2021-12-31' and category='인문'
order by published_Date;