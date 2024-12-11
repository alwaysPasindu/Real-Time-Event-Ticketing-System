const Ticket = require('../models/ticket');
const config = require('../config/config');

// Get all tickets (Consumers/Customers can check available tickets)
const getTickets = async (req, res) => {
  try {
    const tickets = await Ticket.getAllTickets();
    res.status(200).json(tickets);
  } catch (error) {
    res.status(500).json({ error: 'Error fetching tickets' });
  }
};

// Add new tickets (Producer logic)
const addTicket = async (req, res) => {
  const { event_name, price, quantity } = req.body;

  if (!event_name || !price || !quantity) {
    return res.status(400).json({ error: 'Missing required fields' });
  }

  try {
    const result = await Ticket.addTicket(event_name, price, quantity);
    res.status(201).json({ message: 'Ticket added successfully', ticketId: result.insertId });
  } catch (error) {
    res.status(500).json({ error: 'Error adding ticket' });
  }
};

// Purchase a ticket (Consumer logic)
const purchaseTicket = async (req, res) => {
  const { ticketId, quantity } = req.body;

  if (!ticketId || !quantity) {
    return res.status(400).json({ error: 'Ticket ID and quantity are required' });
  }

  try {
    const message = await Ticket.updateTicketQuantity(ticketId, quantity);
    res.status(200).json({ message });
  } catch (error) {
    res.status(400).json({ error: error });
  }
};

// Export functions for use in routes
module.exports = {
  getTickets,
  addTicket,
  purchaseTicket
};
