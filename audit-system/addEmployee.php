<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$emp_id = $data['emp_id'];
$name = $data['name'];
$salary = $data['salary'];

$sql = "INSERT INTO employees(emp_id,name,salary)
        VALUES($emp_id,'$name',$salary)";

if($conn->query($sql)){
    echo "Employee Added Successfully";
} else {
    echo "Error: " . $conn->error;
}
?>