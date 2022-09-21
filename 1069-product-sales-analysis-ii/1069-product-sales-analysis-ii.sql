# Write your MySQL query statement below


Select Product.product_id,Sum(Sales.quantity) as total_quantity from Product inner join Sales
on Product.product_id=Sales.product_id
group by Product.product_id 