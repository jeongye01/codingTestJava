-- v(2024.05.30)
WITH Percentage AS
(
    SELECT 
        ID, 
        NTILE(4) OVER (ORDER BY size_of_colony DESC) AS size_group
    FROM 
        ECOLI_DATA
),
colonynames as (
   select id, 
          case
               when size_group = 1 then 'CRITICAL'
               when size_group = 2 then 'HIGH'
               when size_group = 3 then 'MEDIUM'
               when size_group = 4 then 'LOW'
         end as colony_name
    from percentage
)
select id,colony_name from colonynames order by id;
