# Write your MySQL query statement below
select a as id, count(b) as num from
(select requester_id  as a, accepter_id  as b from RequestAccepted 
union
select accepter_id  as a, requester_id  as b from RequestAccepted ) as T
group by a
order by num desc limit 1;