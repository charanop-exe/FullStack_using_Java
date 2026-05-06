<?php
include "config.php";

$sql = "
SELECT customers.name,
products.product_name,
products.price,
orders.quantity,
(products.price * orders.quantity) AS total
FROM orders
JOIN customers ON orders.customer_id = customers.id
JOIN products ON orders.product_id = products.id
ORDER BY orders.order_date DESC
";

$result = $conn->query($sql);

$data = [];
while($row = $result->fetch_assoc()){
    $data[] = $row;
}

echo json_encode($data);
?>