document.getElementById("tantrazForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const name = document.getElementById("fullname").value;
  const email = document.getElementById("email").value;
  const category = document.getElementById("category").value;

  if (name === "" || email === "" || category === "") {
    alert("Please fill all required fields");
    return;
  }

  alert("Registration Successful!");
});
