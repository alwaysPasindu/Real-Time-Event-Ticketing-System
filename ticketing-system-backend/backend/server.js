const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');
const ticketRoutes = require('./routes/ticketRoutes');

dotenv.config();

const app = express();

// Middleware to parse JSON request bodies
app.use(bodyParser.json());

// Ticket routes
app.use('/api/tickets', ticketRoutes);

// Test route
app.get('/', (req, res) => {
  res.send('Welcome to the Event Ticketing System API!');
});

// Start the server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
