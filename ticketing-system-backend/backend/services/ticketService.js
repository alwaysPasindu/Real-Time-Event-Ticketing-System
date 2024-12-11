const db = require('../config/db');

// Add tickets to the pool (vendor action)
const addTickets = (vendorId, ticketsToAdd) => {
  return new Promise((resolve, reject) => {
    db.query('SELECT available_tickets FROM tickets WHERE id = 1', (err, results) => {
      if (err) return reject(err);
      let availableTickets = results[0].available_tickets;
      availableTickets += ticketsToAdd;

      // Update the available tickets in the database
      db.query(
        'UPDATE tickets SET available_tickets = ? WHERE id = 1',
        [availableTickets],
        (err, result) => {
          if (err) return reject(err);
          // Log vendor activity
          db.query(
            'INSERT INTO vendors (name, tickets_added) VALUES (?, ?)',
            [`Vendor ${vendorId}`, ticketsToAdd],
            (err, result) => {
              if (err) return reject(err);
              resolve(`Vendor ${vendorId} added ${ticketsToAdd} tickets.`);
            }
          );
        }
      );
    });
  });
};

// Remove tickets from the pool (customer action)
const purchaseTickets = (customerId, ticketsToBuy) => {
  return new Promise((resolve, reject) => {
    db.query('SELECT available_tickets FROM tickets WHERE id = 1', (err, results) => {
      if (err) return reject(err);
      let availableTickets = results[0].available_tickets;

      if (availableTickets < ticketsToBuy) {
        return reject('Not enough tickets available');
      }

      availableTickets -= ticketsToBuy;
      // Update the available tickets in the database
      db.query(
        'UPDATE tickets SET available_tickets = ? WHERE id = 1',
        [availableTickets],
        (err, result) => {
          if (err) return reject(err);
          resolve(`Customer ${customerId} purchased ${ticketsToBuy} tickets.`);
        }
      );
    });
  });
};

module.exports = { addTickets, purchaseTickets };
