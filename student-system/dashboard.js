async function loadStudents() {
    const sort = document.getElementById("sortSelect").value;
    const dept = document.getElementById("departmentFilter").value;

    let url = "http://localhost/task2/getStudents.php?";

    if (sort) url += "sort=" + sort + "&";
    if (dept) url += "department=" + dept;

    const res = await fetch(url);
    const students = await res.json();

    const table = document.getElementById("studentTable");
    table.innerHTML = "";

    let deptCount = {};

    students.forEach(s => {
        table.innerHTML += `
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.dob}</td>
                <td>${s.department}</td>
                <td>${s.phone}</td>
            </tr>
        `;

        // Count departments
        deptCount[s.department] = (deptCount[s.department] || 0) + 1;
    });

    // Display department count
    let countHTML = "";
    for (let dept in deptCount) {
        countHTML += `<p>${dept}: ${deptCount[dept]}</p>`;
    }

    document.getElementById("deptCount").innerHTML = countHTML;
}

// Load automatically
window.onload = loadStudents;