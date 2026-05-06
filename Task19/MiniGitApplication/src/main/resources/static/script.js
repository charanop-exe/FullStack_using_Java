function commit() { 
    const content = document.getElementById("content").value; 
    const message = document.getElementById("message").value; 
    fetch("/commit", { 
        method: "POST", 
        headers: {"Content-Type":"application/json"}, 
        body: JSON.stringify({ content, message }) 
    }).then(loadHistory); 
} 
function loadHistory() {
    fetch("/history")
    .then(res => res.json())
    .then(data => {
        let list = document.getElementById("history");
        list.innerHTML = "";

        data.forEach(c => {
            let li = document.createElement("li");

            li.innerText = `v${c.version}: ${c.message} (${new Date(c.time).toLocaleString()})`;

            // 👉 Add click event
            li.onclick = () => {
                document.getElementById("content").value = c.content;
            };

            list.appendChild(li);
        });
    });
}
function clearHistory() {
    fetch("/clear", { method: "DELETE" })
    .then(loadHistory);
}