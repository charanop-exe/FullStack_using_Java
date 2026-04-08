document.addEventListener("mousemove", function (event) {

    const x = event.clientX; // mouse X position
    const y = event.clientY; // mouse Y position

    const width = window.innerWidth;
    const height = window.innerHeight;

    const info = document.getElementById("info");

    // Quadrant logic
    if (x < width / 2 && y < height / 2) {
        document.body.style.backgroundColor = "#ff6b6b"; // Top Left
        info.textContent = "Top Left Quadrant";
    } 
    else if (x >= width / 2 && y < height / 2) {
        document.body.style.backgroundColor = "#4dabf7"; // Top Right
        info.textContent = "Top Right Quadrant";
    } 
    else if (x < width / 2 && y >= height / 2) {
        document.body.style.backgroundColor = "#51cf66"; // Bottom Left
        info.textContent = "Bottom Left Quadrant";
    } 
    else {
        document.body.style.backgroundColor = "#fcc419"; // Bottom Right
        info.textContent = "Bottom Right Quadrant";
    }
});
