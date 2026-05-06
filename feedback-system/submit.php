<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$name = $data['name'];
$email = $data['email'];
$message = $data['message'];

$sql = "INSERT INTO feedback(name,email,message)
        VALUES('$name','$email','$message')";

if($conn->query($sql)){
    echo json_encode(["status"=>"success"]);
}else{
    echo json_encode(["status"=>"error"]);
}
?>