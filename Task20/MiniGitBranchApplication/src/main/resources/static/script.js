function createBranch() { 
    const name = document.getElementById("branchName").value; 
    fetch("/branch", { 
        method: "POST", 
        headers: {"Content-Type":"application/json"}, 
        body: JSON.stringify({ name }) 
    }).then(load); 
} 
function commit() { 
    const message = document.getElementById("message").value; 
    fetch("/commit", { 
        method: "POST", 
        headers: {"Content-Type":"application/json"}, 
        body: JSON.stringify({ message }) 
    }).then(load); 
} 
function merge() { 
    fetch("/merge", { method: "POST" }) 
    .then(res => res.json()) 
    .then(alert) 
    .then(load); 
} 
function rebase() { 
    fetch("/rebase", { method: "POST" }) 
    .then(load); 
} 
function load() { 
    fetch("/data") 
    .then(res => res.json()) 
    .then(data => { 
        let b = document.getElementById("branches"); 
        let h = document.getElementById("history"); 
        b.innerHTML = ""; 
        h.innerHTML = ""; 
        data.branches.forEach(br => { 
            let li = document.createElement("li"); 
            li.innerText = br; 
            b.appendChild(li); 
        }); 
data.history.forEach(c => { 
            let li = document.createElement("li"); 
            li.innerText = c; 
            h.appendChild(li); 
        }); 
    }); 
} 
load();