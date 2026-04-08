<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$conn = new mysqli("localhost", "root", "", "studentdb");

$result = $conn->query("SELECT * FROM students");

if (!$result) {
    die("Query Failed");
}

echo "<table border='1'>
<tr>
<th>ID</th><th>Name</th><th>Email</th><th>DOB</th><th>Department</th><th>Phone</th>
</tr>";

while ($row = $result->fetch_assoc()) {
    echo "<tr>
    <td>{$row['id']}</td>
    <td>{$row['name']}</td>
    <td>{$row['email']}</td>
    <td>{$row['dob']}</td>
    <td>{$row['department']}</td>
    <td>{$row['phone']}</td>
    </tr>";
}

echo "</table>";

$conn->close();
?>