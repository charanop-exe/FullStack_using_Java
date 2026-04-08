const products = [
    { name: "Nike Shoes", price: 4000, color: "red", brand: "Nike", rating: 4 },
    { name: "Adidas Sneakers", price: 3500, color: "blue", brand: "Adidas", rating: 5 },
    { name: "Puma Runner", price: 2500, color: "black", brand: "Puma", rating: 3 },
    { name: "Nike Air", price: 4500, color: "black", brand: "Nike", rating: 5 }
];

const productList = document.getElementById("productList");
const priceInput = document.getElementById("price");
const priceValue = document.getElementById("priceValue");

priceInput.oninput = () => {
    priceValue.textContent = `Up to ₹${priceInput.value}`;
};

function displayProducts(items) {
    productList.innerHTML = "";
    items.forEach(p => {
        productList.innerHTML += `
            <div class="product">
                <h4>${p.name}</h4>
                <span>₹${p.price}</span><br>
                <span>${p.brand}</span><br>
                <span>${p.color}</span><br>
                <span>${p.rating} ★</span>
            </div>
        `;
    });
}

function applyFilters() {
    const maxPrice = priceInput.value;
    const brand = document.getElementById("brand").value;
    const rating = document.getElementById("rating").value;

    const colors = [...document.querySelectorAll(".colors input:checked")]
        .map(c => c.value);

    let filtered = products.filter(p =>
        p.price <= maxPrice &&
        (brand === "all" || p.brand === brand) &&
        p.rating >= rating &&
        (colors.length === 0 || colors.includes(p.color))
    );

    displayProducts(filtered);
}

displayProducts(products);
