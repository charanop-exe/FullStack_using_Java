<?php
$conn = new mysqli("localhost", "root", "", "paymentdb");

if ($conn->connect_error) {
    die("Connection Failed: " . $conn->connect_error);
}
?>