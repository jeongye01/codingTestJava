-- v(2024.05.07)
SELECT COUNT(*) AS FISH_COUNT, B.FISH_NAME
FROM FISH_INFO A, FISH_NAME_INFO B
WHERE A.FISH_TYPE = B.FISH_TYPE
GROUP BY A.FISH_TYPE, B.FISH_NAME
ORDER BY FISH_COUNT DESC;