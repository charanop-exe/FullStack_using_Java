// i) Create two arrays
const collegeFriends = ["Arun", "Kiran", "Ravi"];
const workFriends = ["Anita", "Priya", "Rahul"];

// Merge arrays using SPREAD operator
const partyList = ["Me", ...collegeFriends, ...workFriends];

// ii) Function using normal parameter + REST operator
const welcomeParty = (host, ...guests) => {
    return `Host: ${host}\nGuests: ${guests.join(", ")}`;
};

// Display output
document.getElementById("output").textContent =
`Party List:
${partyList.join(", ")}

${welcomeParty("Me", ...partyList)}`;
