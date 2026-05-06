<?php
include "config.php";

$sort = isset($_GET['sort']) ? $_GET['sort'] : '';
$department = isset($_GET['department']) ? $_GET['department'] : '';

$sql = "SELECT * FROM students WHERE 1=1";

// Filter
if (!empty($department)) {
    $sql .= " AND department='$department'";
}

// Sort
if ($sort == "name") {
    $sql .= " ORDER BY name ASC";
} elseif ($sort == "dob") {
    $sql .= " ORDER BY dob ASC";
}

$result = $conn->query($sql);

$students = [];

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $students[] = $row;
    }
}

echo json_encode($students);
$conn->close();
?>