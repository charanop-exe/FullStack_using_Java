// Function that returns a Promise
const orderPizza = (pizzaType) => {
    return new Promise((resolve, reject) => {
        if (pizzaType === "Veg") {
            resolve(`✅ Your ${pizzaType} pizza is ready!`);
        } else {
            reject(`❌ Sorry, ${pizzaType} pizza is not available.`);
        }
    });
};

// Using the Promise
orderPizza("Veg")
    .then(message => {
        document.getElementById("output").textContent = message;
    })
    .catch(error => {
        document.getElementById("output").textContent = error;
    });
