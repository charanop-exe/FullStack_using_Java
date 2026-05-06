let usersData = []
let merchantsData = []

async function loadData(){
const res = await fetch("http://localhost/payment-system/getBalances.php")
const data = await res.json()

usersData = data.users
merchantsData = data.merchants

let userSelect = document.getElementById("user")
let merchantSelect = document.getElementById("merchant")

userSelect.innerHTML=""
merchantSelect.innerHTML=""

// users
usersData.forEach(u=>{
userSelect.innerHTML += `<option value="${u.id}">${u.name}</option>`
})

// merchants
merchantsData.forEach(m=>{
merchantSelect.innerHTML += `<option value="${m.id}">${m.name}</option>`
})

updateBalances()
}

function updateBalances(){
let userId = document.getElementById("user").value
let merchantId = document.getElementById("merchant").value

let user = usersData.find(u=>u.id == userId)
let merchant = merchantsData.find(m=>m.id == merchantId)

document.getElementById("userBalance").innerText =
"User Balance: Rs" + (user ? user.balance : 0)

document.getElementById("merchantBalance").innerText =
"Shop Balance: Rs" + (merchant ? merchant.balance : 0)
}

function pay(){
let userId = document.getElementById("user").value
let merchantId = document.getElementById("merchant").value
let amount = document.getElementById("amount").value

fetch("http://localhost/payment-system/pay.php",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({userId,merchantId,amount})
})
.then(res=>res.json())
.then(data=>{
document.getElementById("result").innerText = data.message
loadData()
})
}

window.onload = loadData