# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary 
FROM employee WHERE salary not in(SELECT MAX(salary) 
FROM employee);
