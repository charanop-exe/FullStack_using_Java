<?php
$conn = new mysqli("localhost", "root", "", "audit_db");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>