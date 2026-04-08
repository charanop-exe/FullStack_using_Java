const box = document.getElementById("box");

let x = 100; // horizontal position
let y = 100; // vertical position
const speed = 10; // movement speed

// Global keyboard listener
document.addEventListener("keydown", function (event) {

    switch (event.key) {
        case "ArrowUp":
        case "w":
            y -= speed;
            break;

        case "ArrowDown":
        case "s":
            y += speed;
            break;

        case "ArrowLeft":
        case "a":
            x -= speed;
            break;

        case "ArrowRight":
        case "d":
            x += speed;
            break;
    }

    box.style.left = x + "px";
    box.style.top = y + "px";
});
