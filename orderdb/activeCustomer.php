<?php
include "config.php";

$sql = "
SELECT customers.name,
COUNT(orders.id) AS total_orders
FROM customers
JOIN orders ON customers.id = orders.customer_id
GROUP BY customers.id
ORDER BY total_orders DESC
LIMIT 1
";

$result = $conn->query($sql);

$data = [];
while($row = $result->fetch_assoc()){
    $data[] = $row;
}

echo json_encode($data);
?>