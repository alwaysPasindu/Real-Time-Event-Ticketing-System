const express = require('express');
const router = express.Router();
const ticketController = require('../controllers/ticketController');

// Route for getting all tickets
router.get('/', ticketController.getTickets);

// Route for adding tickets (for vendors)
router.post('/', ticketController.addTicket);

// Route for purchasing tickets (for customers)
router.post('/purchase', ticketController.purchaseTicket);

module.exports = router;
