// Sample student / employee data
const records = [
    { name: "Alice", department: "IT", date: "2024-01-10" },
    { name: "Bob", department: "HR", date: "2023-11-22" },
    { name: "Charlie", department: "IT", date: "2024-02-01" },
    { name: "Diana", department: "Finance", date: "2023-12-15" },
    { name: "Ethan", department: "HR", date: "2024-01-05" }
];

const tableBody = document.getElementById("tableBody");
const sortSelect = document.getElementById("sortSelect");
const deptFilter = document.getElementById("deptFilter");
const countList = document.getElementById("countList");

// Render table
function renderTable(data) {
    tableBody.innerHTML = "";

    data.forEach(record => {
        const row = `
            <tr>
                <td>${record.name}</td>
                <td>${record.department}</td>
                <td>${record.date}</td>
            </tr>
        `;
        tableBody.innerHTML += row;
    });
}

// Count students/employees per department
function updateCounts(data) {
    const counts = {};

    data.forEach(record => {
        counts[record.department] = (counts[record.department] || 0) + 1;
    });

    countList.innerHTML = "";
    for (let dept in counts) {
        const li = document.createElement("li");
        li.textContent = `${dept}: ${counts[dept]}`;
        countList.appendChild(li);
    }
}

// Main update function
function updateDashboard() {
    let filteredData = [...records];

    // Filter
    if (deptFilter.value !== "All") {
        filteredData = filteredData.filter(
            r => r.department === deptFilter.value
        );
    }

    // Sort
    if (sortSelect.value === "name") {
        filteredData.sort((a, b) => a.name.localeCompare(b.name));
    } else {
        filteredData.sort((a, b) => new Date(a.date) - new Date(b.date));
    }

    renderTable(filteredData);
    updateCounts(filteredData);
}

// Event listeners
sortSelect.addEventListener("change", updateDashboard);
deptFilter.addEventListener("change", updateDashboard);

// Initial load
updateDashboard();
