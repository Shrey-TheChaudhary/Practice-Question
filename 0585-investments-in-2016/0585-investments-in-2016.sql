SELECT ROUND(SUM(tiv_2016),2) as tiv_2016 FROM Insurance
WHERE 
pid NOT IN
(SELECT a.pid FROM Insurance a
INNER JOIN Insurance b on (a.lat,a.lon) = (b. lat,b.lon)
WHERE a.pid <> b.pid)
AND
tiv_2015 IN
(SELECT tiv_2015 FROM Insurance
GROUP BY tiv_2015 HAVING COUNT(pid)>1);