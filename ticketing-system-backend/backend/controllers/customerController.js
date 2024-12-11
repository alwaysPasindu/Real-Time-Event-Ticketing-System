const Ticket = require('../models/ticket');

// Handle purchasing tickets (customer logic)
const purchaseTicket = async (req, res) => {
  const { ticketId, quantity } = req.body;

  // Check if ticketId and quantity are provided
  if (!ticketId || !quantity) {
    return res.status(400).json({ error: 'Ticket ID and quantity are required' });
  }

  try {
    // Update the ticket quantity in the database
    const message = await Ticket.updateTicketQuantity(ticketId, quantity);
    res.status(200).json({ message });  // Success response
  } catch (error) {
    // Handle errors, like not enough tickets available
    res.status(400).json({ error: error });
  }
};

// Export the controller functions
module.exports = {
  purchaseTicket
};
