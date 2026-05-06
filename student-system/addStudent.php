<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$name = $data['name'];
$email = $data['email'];
$dob = $data['dob'];
$department = $data['department'];
$phone = $data['phone'];

$sql = "INSERT INTO students (name, email, dob, department, phone)
        VALUES ('$name', '$email', '$dob', '$department', '$phone')";

if ($conn->query($sql) === TRUE) {
    echo "Student Added Successfully";
} else {
    echo "Error: " . $conn->error;
}

$conn->close();
?>