// SIGN IN VALIDATION
document.getElementById("signinForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const email = document.getElementById("signin-email").value;
  const password = document.getElementById("signin-password").value;
  const error = document.getElementById("signin-error");

  if (!email || !password) {
    error.textContent = "All fields are required.";
  } else {
    error.textContent = "";
    alert("Sign In Successful");
  }
});

// SIGN UP VALIDATION
document.getElementById("signupForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const password = document.getElementById("password").value;
  const confirm = document.getElementById("confirm-password").value;
  const error = document.getElementById("signup-error");

  if (password !== confirm) {
    error.textContent = "Passwords do not match.";
  } else {
    error.textContent = "";
    alert("Sign Up Successful");
  }
});
