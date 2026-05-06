const nameInput = document.getElementById("name");
const emailInput = document.getElementById("email");
const messageInput = document.getElementById("message");
const submitBtn = document.getElementById("submitBtn");

function validateName() {
if (nameInput.value.length < 3) {
document.getElementById("nameError").innerText = "Min 3 characters";
return false;
}
document.getElementById("nameError").innerText = "";
return true;
}

function validateEmail() {
let pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
if (!emailInput.value.match(pattern)) {
document.getElementById("emailError").innerText = "Invalid email";
return false;
}
document.getElementById("emailError").innerText = "";
return true;
}

function validateMessage() {
if (messageInput.value.length < 5) {
document.getElementById("msgError").innerText = "Too short";
return false;
}
document.getElementById("msgError").innerText = "";
return true;
}

// REAL-TIME EVENTS
nameInput.addEventListener("keyup", validateName);
emailInput.addEventListener("keyup", validateEmail);
messageInput.addEventListener("keyup", validateMessage);

// DOUBLE CLICK SUBMIT
submitBtn.addEventListener("dblclick", () => {
if (validateName() && validateEmail() && validateMessage()) {
sendData();
} else {
alert("Fix errors before submitting!");
}
});

function sendData() {
fetch("submit.php", {
method: "POST",
headers: {
"Content-Type": "application/json"
},
body: JSON.stringify({
name: nameInput.value,
email: emailInput.value,
message: messageInput.value
})
})
.then(res => res.json())
.then(data => {
if(data.status === "success"){
document.getElementById("successMsg").innerText = " Feedback Submitted!";
document.getElementById("feedbackForm").reset();
}else{
alert("Error saving data");
}
})
.catch(err=>{
console.log(err);
alert("Server error");
});
}