# SELECT ROUND(SUM(tiv_2016),2) as tiv_2016 FROM Insurance
# WHERE 
# pid NOT IN
# (SELECT a.pid FROM Insurance a
# INNER JOIN Insurance b on (a.lat,a.lon) = (b. lat,b.lon)
# WHERE a.pid <> b.pid)
# AND
# tiv_2015 IN
# (SELECT tiv_2015 FROM Insurance
# GROUP BY tiv_2015 HAVING COUNT(pid)>1);

SELECT
    ROUND(SUM(tiv_2016), 2) as tiv_2016
FROM Insurance i
WHERE NOT EXISTS (
    SELECT * FROM Insurance i2 WHERE i2.pid != i.pid AND i2.lat = i.lat AND i2.lon = i.lon
) AND tiv_2015 IN (
    SELECT tiv_2015 FROM Insurance i3 WHERE i3.pid != i.pid
)