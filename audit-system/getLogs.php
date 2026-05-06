<?php
include "config.php";

$result = $conn->query("SELECT * FROM logs ORDER BY action_time DESC");

$data = [];
while($row = $result->fetch_assoc()){
    $data[] = $row;
}

echo json_encode($data);
?>