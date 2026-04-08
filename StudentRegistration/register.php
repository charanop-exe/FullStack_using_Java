<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$conn = new mysqli("localhost", "root", "", "studentdb");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$name = $_POST['name'];
$email = $_POST['email'];
$dob = $_POST['dob'];
$department = $_POST['department'];
$phone = $_POST['phone'];

$sql = "INSERT INTO students (name, email, dob, department, phone)
        VALUES ('$name', '$email', '$dob', '$department', '$phone')";

if ($conn->query($sql) === TRUE) {
    echo "Student Registered Successfully";
} else {
    echo "Error: " . $conn->error;
}

$conn->close();
?>