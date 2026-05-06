<?php
include "config.php";

$id = $_GET['id'];

$data = json_decode(file_get_contents("php://input"), true);
$salary = $data['salary'];

$sql = "UPDATE employees SET salary=$salary WHERE emp_id=$id";

if($conn->query($sql)){
    echo "Employee Updated Successfully";
} else {
    echo "Error: " . $conn->error;
}
?>