const form = document.getElementById("studentForm");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        dob: document.getElementById("dob").value,
        department: document.getElementById("department").value,
        phone: document.getElementById("phone").value
    };

    // Basic validation
    if (!student.name || !student.email || !student.dob || !student.department || !student.phone) {
        alert("Please fill all fields");
        return;
    }

    try {
        const res = await fetch("http://localhost/task2/addStudent.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(student)
        });

        const data = await res.text();
        alert(data);
        form.reset();

    } catch (error) {
        console.log("Error:", error);
        alert("Server error");
    }
});

function goHome(){
    window.location.href = "index.html";
}