document.getElementById("tantrazForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const name = document.getElementById("fullname").value;
  const email = document.getElementById("email").value;
  const category = document.getElementById("category").value;

  if (!name || !email || !category) {
    alert("Name, Email, and Category are mandatory.");
    return;
  }

  alert("Registration Successful!");
});
