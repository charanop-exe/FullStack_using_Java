// LOGIN FUNCTION
function login(){
const username=document.getElementById("username").value
const password=document.getElementById("password").value

fetch("http://localhost/orderdb/login.php",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({username,password})
})
.then(res=>res.json())
.then(data=>{
if(data.success){
window.location="admindashboard.html"
}else{
alert("Invalid login")
}
})
.catch(err=>{
console.log("Error:",err); // 👈 ADD THIS
alert("Server error")
})
}

// ADD CUSTOMER
function addCustomer(){
fetch("http://localhost/orderdb/addCustomer.php",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({
name:document.getElementById("cname").value,
email:document.getElementById("cemail").value
})
})
.then(res=>res.text())
.then(alert)
}

// ADD PRODUCT
function addProduct(){
fetch("http://localhost/orderdb/addProduct.php",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({
product:document.getElementById("pname").value,
price:document.getElementById("pprice").value
})
})
.then(res=>res.text())
.then(alert)
}

// LOAD CUSTOMERS
async function loadCustomers(){
const res = await fetch("http://localhost/orderdb/getCustomers.php")
const data = await res.json()

let select=document.getElementById("customerSelect")
if(!select) return

select.innerHTML='<option value="">Select Customer</option>'

data.forEach(c=>{
select.innerHTML+=`<option value="${c.id}">${c.name}</option>`
})
}

// LOAD PRODUCTS
async function loadProducts(){
const res = await fetch("http://localhost/orderdb/getProducts.php")
const data = await res.json()

let select=document.getElementById("productSelect")
if(!select) return

select.innerHTML='<option value="">Select Product</option>'

data.forEach(p=>{
select.innerHTML+=`<option value="${p.id}">${p.product_name}</option>`
})
}

// PLACE ORDER
function placeOrder(){
fetch("http://localhost/orderdb/placeOrder.php",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({
customer_id:document.getElementById("customerSelect").value,
product_id:document.getElementById("productSelect").value,
quantity:document.getElementById("qty").value
})
})
.then(res=>res.text())
.then(alert)
}

// ORDER HISTORY (JOIN)
async function loadOrders(){
const res=await fetch("http://localhost/orderdb/getOrders.php")
const data=await res.json()

let html="<table><tr><th>Customer</th><th>Product</th><th>Price</th><th>Qty</th><th>Total</th></tr>"

data.forEach(o=>{
html+=`
<tr>
<td>${o.name}</td>
<td>${o.product_name}</td>
<td>${o.price}</td>
<td>${o.quantity}</td>
<td>${o.total}</td>
</tr>
`
})

html+="</table>"
document.getElementById("result").innerHTML=html
}

// HIGHEST ORDER
async function highestOrder(){
const res=await fetch("http://localhost/orderdb/highestOrder.php")
const data=await res.json()

document.getElementById("result").innerHTML=
`<h2>Highest Order</h2>
${data[0].name} - ₹${data[0].total}`
}

// MOST ACTIVE CUSTOMER
async function activeCustomer(){
const res=await fetch("http://localhost/orderdb/activeCustomer.php")
const data=await res.json()

document.getElementById("result").innerHTML=
`<h2>Most Active Customer</h2>
${data[0].name} (${data[0].total_orders} orders)`
}

// LOAD DROPDOWNS
window.onload=function(){
loadCustomers()
loadProducts()
}