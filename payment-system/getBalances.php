<?php
include "config.php";

$users = [];
$merchants = [];

$res1 = $conn->query("SELECT * FROM users");
while($row = $res1->fetch_assoc()){
    $users[] = $row;
}

$res2 = $conn->query("SELECT * FROM merchants");
while($row = $res2->fetch_assoc()){
    $merchants[] = $row;
}

echo json_encode([
    "users" => $users,
    "merchants" => $merchants
]);
?>