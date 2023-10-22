# Write your MySQL query statement below
select id , sum(cnt) as num from
(
  (select requester_id as id, count(*) as cnt from RequestAccepted group by requester_id)
union all
(select accepter_id as id, count(*) as cnt from RequestAccepted group by accepter_id) 
) t3
group by id
order by num desc limit 1