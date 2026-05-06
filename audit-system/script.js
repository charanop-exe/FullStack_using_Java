const BASE_URL = "http://localhost/audit-system";
// Add Employee
function addEmployee() {
const data = {
emp_id: document.getElementById("emp_id").value,
name: document.getElementById("name").value,
salary: document.getElementById("salary").value
};
fetch(`${BASE_URL}/addEmployee.php`, {
method: "POST",
headers: { "Content-Type": "application/json" },
body: JSON.stringify(data)
})
.then(res => res.text())
.then(data => alert(data));
}
// Update Employee
function updateEmployee() {
const id = document.getElementById("update_id").value;
const salary = document.getElementById("new_salary").value;
fetch(`${BASE_URL}/updateEmployee.php?id=${id}`, {
method: "PUT",
headers: { "Content-Type": "application/json" },
body: JSON.stringify({ salary })
})
.then(res => res.text())
.then(data => alert(data));
}
// Load Logs
function loadLogs() {
fetch(`${BASE_URL}/getLogs.php`)
.then(res => res.json())
.then(data => {
document.getElementById("output").innerText =
JSON.stringify(data, null, 2);
});
}
// Load Report
function loadReport() {
fetch(`${BASE_URL}/getReport.php`)
.then(res => res.json())
.then(data => {
document.getElementById("output").innerText =
JSON.stringify(data, null, 2);
});
}