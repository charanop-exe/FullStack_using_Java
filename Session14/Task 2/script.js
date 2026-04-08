// Input values
const price = 500;
const tip = 50;

// Arrow function using Template Literals
const generateReceipt = (price, tip) => {
    const total = price + tip;

    const message = `Price: ₹${price}<br>
                     Tip: ₹${tip}<br>
                     Total Amount: ₹${total}`;

    document.getElementById("output").innerHTML = message;
};

// Function call
generateReceipt(price, tip);
