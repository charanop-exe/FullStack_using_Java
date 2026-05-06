<?php
include "config.php";

$data = json_decode(file_get_contents("php://input"), true);

$userId = $data['userId'];
$merchantId = $data['merchantId'];
$amount = (int)$data['amount'];

if($amount <= 0){
    echo json_encode(["message"=>"Enter valid amount"]);
    exit();
}

// START TRANSACTION
$conn->begin_transaction();

try {

    // 1. Get user balance
    $res = $conn->query("SELECT balance FROM users WHERE id=$userId");
    if($res->num_rows == 0){
        throw new Exception("User not found");
    }

    $row = $res->fetch_assoc();
    $balance = $row['balance'];

    if($balance < $amount){
        throw new Exception("Insufficient Balance");
    }

    // 2. Deduct from user
    $conn->query("UPDATE users SET balance = balance - $amount WHERE id=$userId");

    // 3. Add to merchant
    $conn->query("UPDATE merchants SET balance = balance + $amount WHERE id=$merchantId");

    // COMMIT
    $conn->commit();

    echo json_encode(["message"=>"Payment Successful"]);

} catch(Exception $e){

    // ROLLBACK
    $conn->rollback();

    echo json_encode(["message"=>$e->getMessage()]);
}
?>