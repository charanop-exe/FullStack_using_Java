<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$name = $data['name'];
$email = $data['email'];

$sql = "INSERT INTO customers(name,email) VALUES('$name','$email')";
$conn->query($sql);

echo "Customer Added Successfully";
?>