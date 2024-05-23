-- v(2024.05.23)
select m.MEMBER_NAME,r.REVIEW_TEXT,date_format(r.REVIEW_DATE,'%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE m join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID
where m.MEMBER_ID = (
SELECT m.MEMBER_ID
from MEMBER_PROFILE m join REST_REVIEW r on m.MEMBER_ID = r.MEMBER_ID
group by r.MEMBER_ID
order by count(*) desc limit 1)
order by REVIEW_DATE,r.REVIEW_TEXT;
