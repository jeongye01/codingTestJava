-- v(2024.05.30)
with recursive gen_data as (
   select
      id,
      parent_id,
      1 as gen
   from ecoli_data
   where parent_id is null
   union all
   select
       e.id,
       e.parent_id,
       (gen + 1) as gen
   from ecoli_data e
   inner join gen_data g on e.parent_id = g.id
)
select id from gen_data
where gen = 3
order by id;