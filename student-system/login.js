const form = document.getElementById("loginForm");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    };

    // Validation
    if (!user.username || !user.password) {
        document.getElementById("errorMsg").innerText = "All fields required";
        return;
    }

    try {
        const res = await fetch("http://localhost/student-system/login.php", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        });

        const result = await res.text();

        if (result === "success") {
            window.location.href = "dashboard.html";
        } else {
            document.getElementById("errorMsg").innerText = "Invalid Username/Password";
        }

    } catch (error) {
        console.log(error);
    }
});