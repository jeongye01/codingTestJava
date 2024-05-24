-- v(2024.05.24)
select ID, (select count(*) from ECOLI_DATA where ED.ID = PARENT_ID) as CHILD_COUNT from ECOLI_DATA ED
order by ID;

-- ,count(*) as CHILD_COUNT