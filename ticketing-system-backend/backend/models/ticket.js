const pool = require('../config/db');

// Get all tickets from the database
const getAllTickets = () => {
  return new Promise((resolve, reject) => {
    pool.query('SELECT * FROM tickets', (err, results) => {
      if (err) reject(err);
      resolve(results);
    });
  });
};

// Add new tickets (by vendor)
const addTicket = (event_name, price, quantity) => {
  return new Promise((resolve, reject) => {
    pool.query(
      'INSERT INTO tickets (event_name, price, quantity) VALUES (?, ?, ?)',
      [event_name, price, quantity],
      (err, result) => {
        if (err) reject(err);
        resolve(result);
      }
    );
  });
};

// Update ticket quantity (when customer buys tickets)
const updateTicketQuantity = (ticketId, quantity) => {
  return new Promise((resolve, reject) => {
    pool.query(
      'UPDATE tickets SET quantity = quantity - ? WHERE id = ? AND quantity >= ?',
      [quantity, ticketId, quantity],
      (err, result) => {
        if (err) reject(err);
        if (result.affectedRows > 0) {
          resolve('Ticket quantity updated');
        } else {
          reject('Not enough tickets available');
        }
      }
    );
  });
};

// Export functions for use in controllers
module.exports = {
  getAllTickets,
  addTicket,
  updateTicketQuantity
};
