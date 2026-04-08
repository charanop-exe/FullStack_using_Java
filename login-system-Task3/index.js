const express = require("express");
const mysql = require("mysql2");
const app = express();

app.use(express.urlencoded({ extended: true }));

// DB connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root@123",       // put your MySQL password if you have one
  database: "login_db"
});

db.connect(err => {
  if (err) {
    console.log("DB connection failed");
    return;
  }
  console.log("DB connected");
});

// Login page
app.get("/", (req, res) => {
  res.send(`
    <h2>Login</h2>
    <form method="POST" action="/login">
      <input name="username" placeholder="Username" required /><br><br>
      <input type="password" name="password" placeholder="Password" required /><br><br>
      <button type="submit">Login</button>
    </form>
  `);
});

// Login check
app.post("/login", (req, res) => {
  const { username, password } = req.body;

  const sql = "SELECT * FROM users WHERE username=? AND password=?";
  db.query(sql, [username, password], (err, result) => {
    if (result.length > 0) {
      res.send("Login successful (DB)");
    } else {
      res.send("Invalid username or password");
    }
  });
});

app.listen(3000, () => {
  console.log("Server running on http://localhost:3000");
});
