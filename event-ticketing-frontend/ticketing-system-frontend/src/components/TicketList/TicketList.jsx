import React from 'react';
import useTickets from '../../hooks/useTickets';
import './TicketList.css';

const TicketList = () => {
  const { tickets, loading, error } = useTickets();

  if (loading) return <div className="text-center text-gray-600">Loading tickets...</div>;
  if (error) return <div className="text-red-500 text-center">Error: {error}</div>;

  return (
    <div className="ticket-list">
      <h2 className="ticket-list-title">Available Tickets</h2>
      <table className="ticket-table">
        <thead>
          <tr>
            <th>Event Name</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          {tickets.map(ticket => (
            <tr key={ticket.id}>
              <td>{ticket.event_name}</td>
              <td>${ticket.price}</td>
              <td>{ticket.quantity}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TicketList;