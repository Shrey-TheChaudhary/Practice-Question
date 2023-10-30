# Write your MySQL query statement below
select d.name as department , e1.name as employee, e1.salary as Salary
from employee e1, Department d 
where e1.departmentID = d.id and   3 > (
    select count(distinct (e2.Salary))
    from  Employee e2
    where e2.Salary > e1.Salary and e1.DepartmentId = e2.DepartmentId)