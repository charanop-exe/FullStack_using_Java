<?php
$conn = new mysqli("localhost", "root", "", "orderdb");

if ($conn->connect_error) {
    die("Connection Failed: " . $conn->connect_error);
}
?>