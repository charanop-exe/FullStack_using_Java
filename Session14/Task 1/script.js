// State management using const
const matchState = {
    teamA: 0,
    teamB: 0
};

// Update score
function updateScore(team) {
    let message; // block-scoped

    if (team === "A") {
        matchState.teamA++;
        message = "Team A scored";
    } else {
        matchState.teamB++;
        message = "Team B scored";
    }

    renderScore();
    console.log(message);
}

// Render state to UI
const renderScore = () => {
    document.getElementById("score").textContent =
        `Team A: ${matchState.teamA} | Team B: ${matchState.teamB}`;
};

// Event listeners
document.getElementById("teamA").addEventListener("click", () => updateScore("A"));
document.getElementById("teamB").addEventListener("click", () => updateScore("B"));
