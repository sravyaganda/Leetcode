# Write your MySQL query statement below
SELECT firstName,lastName,city,state from 
Person pt left join Address a on pt.personId=a.personId