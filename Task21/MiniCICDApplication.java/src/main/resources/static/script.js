function runPipeline() { 
    fetch("/run", { method: "POST" }) 
    .then(() => loadLogs()); 
} 
function loadLogs() { 
    fetch("/logs") 
    .then(res => res.json()) 
    .then(data => { 
        let list = document.getElementById("logs"); 
        list.innerHTML = ""; 
        data.forEach(log => { 
            let li = document.createElement("li"); 
            li.innerText = log; 
            list.appendChild(li); 
        }); 
    }); 
} 
loadLogs();