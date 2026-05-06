function generate() { 
    const prompt = document.getElementById("prompt").value; 
    fetch("/generate", { 
        method: "POST", 
        headers: {"Content-Type":"application/json"}, 
        body: JSON.stringify({ prompt }) 
    }) 
    .then(res => res.json()) 
    .then(data => { 
        document.getElementById("output").innerText = data.output; 
        document.getElementById("score").innerText = data.score + "/10"; 
        loadHistory(); 
    }); 
} 
function loadHistory() { 
    fetch("/history") 
    .then(res => res.json()) 
    .then(data => { 
        let list = document.getElementById("history"); 
        list.innerHTML = ""; 
        data.forEach((p, i) => { 
            let li = document.createElement("li"); 
            li.innerText = `v${i+1}: ${p.prompt}`; 
            list.appendChild(li); 
        }); 
    }); 
} 
loadHistory();