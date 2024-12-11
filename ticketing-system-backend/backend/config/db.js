const mysql = require('mysql2');
require('dotenv').config();

// Creating a MySQL connection pool for better concurrency handling
const pool = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME
});

module.exports = pool;
