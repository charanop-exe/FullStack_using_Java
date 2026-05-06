<?php
include "config.php";

$sql = "
SELECT customers.name,
(products.price * orders.quantity) AS total
FROM orders
JOIN customers ON orders.customer_id = customers.id
JOIN products ON orders.product_id = products.id
WHERE (products.price * orders.quantity) =
(
SELECT MAX(products.price * orders.quantity)
FROM orders
JOIN products ON orders.product_id = products.id
)
";

$result = $conn->query($sql);

$data = [];
while($row = $result->fetch_assoc()){
    $data[] = $row;
}

echo json_encode($data);
?>