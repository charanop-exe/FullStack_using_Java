<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$cust = $data['customer_id'];
$prod = $data['product_id'];
$qty = $data['quantity'];

$sql = "INSERT INTO orders(customer_id,product_id,quantity)
        VALUES('$cust','$prod','$qty')";

$conn->query($sql);

echo "Order Placed Successfully";
?>