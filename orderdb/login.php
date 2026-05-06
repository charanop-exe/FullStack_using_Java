<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$username = $data['username'];
$password = $data['password'];

$sql = "SELECT * FROM users WHERE username='$username' AND password='$password'";
$result = $conn->query($sql);

if($result->num_rows > 0){
    echo json_encode(["success"=>true]);
}else{
    echo json_encode(["success"=>false]);
}
?>