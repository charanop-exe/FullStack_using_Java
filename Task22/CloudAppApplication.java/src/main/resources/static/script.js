function loadData() { 
    const provider = document.getElementById("provider").value; 
    fetch(`/services/${provider}`) 
    .then(res => res.json()) 
    .then(data => { 
        let list = document.getElementById("services"); 
        list.innerHTML = ""; 
        Object.entries(data).forEach(([key, value]) => { 
            let li = document.createElement("li"); 
            li.innerText = `${key}: ${value}`; 
            list.appendChild(li); 
        }); 
    }); 
} 
function calculate() { 
    const provider = document.getElementById("provider").value; 
    const hours = document.getElementById("hours").value; 
    const storage = document.getElementById("storage").value; 
    fetch("/cost", { 
        method: "POST", 
        headers: {"Content-Type":"application/json"}, 
        body: JSON.stringify({ provider, hours, storage }) 
    }) 
    .then(res => res.json()) 
    .then(data => { 
        document.getElementById("result").innerText = "Cost: $" + data.cost; 
    }); 
} 
loadData(); 