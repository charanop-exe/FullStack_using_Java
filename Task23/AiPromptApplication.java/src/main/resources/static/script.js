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
}); 
}