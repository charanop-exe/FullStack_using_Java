<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$product = $data['product'];
$price = $data['price'];

$sql = "INSERT INTO products(product_name,price) VALUES('$product','$price')";
$conn->query($sql);

echo "Product Added Successfully";
?>