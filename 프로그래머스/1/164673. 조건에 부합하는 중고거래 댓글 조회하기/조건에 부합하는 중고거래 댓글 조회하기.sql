-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID,r.REPLY_ID,r.WRITER_ID,r.CONTENTS, DATE_FORMAT(r.CREATED_DATE , '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as b  join USED_GOODS_REPLY as r on b.board_id = r.board_id 
where DATE_FORMAT(b.created_date, '%Y-%m') = '2022-10'
ORDER BY 
    r.created_date ASC,
    b.title ASC;