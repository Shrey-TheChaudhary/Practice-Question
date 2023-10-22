# Write your MySQL query statement below
(SELECT name AS results
FROM movierating JOIN users USING(user_id)
GROUP BY user_id
ORDER BY count(movie_id) DESC, name
LIMIT 1) 

UNION ALL

(SELECT title AS results
FROM movierating JOIN movies USING(movie_id)
WHERE created_at >= '2020-02-01' AND created_at < '2020-03-01'
GROUP BY title
ORDER BY avg(rating) DESC, title
LIMIT 1) 