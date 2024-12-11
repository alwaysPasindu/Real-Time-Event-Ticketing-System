const { purchaseTickets } = require('../services/ticketService');

// Endpoint for purchasing tickets (simulating a customer)
exports.purchaseTickets = async (req, res) => {
  const { customerId, ticketsToBuy } = req.body;
  try {
    const result = await purchaseTickets(customerId, ticketsToBuy);
    res.status(200).json({ message: result });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
