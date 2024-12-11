const { addTickets } = require('../services/ticketService');

// Endpoint for adding tickets (simulating a vendor)
exports.addTickets = async (req, res) => {
  const { vendorId, ticketsToAdd } = req.body;
  try {
    const result = await addTickets(vendorId, ticketsToAdd);
    res.status(200).json({ message: result });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
