function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.style.display =
        sidebar.style.display === "none" ? "block" : "none";
}

function toggleGrid() {
    const content = document.getElementById("content");
    if (content.classList.contains("grid-layout")) {
        content.classList.remove("grid-layout");
        content.classList.add("list-layout");
    } else {
        content.classList.remove("list-layout");
        content.classList.add("grid-layout");
    }
}
