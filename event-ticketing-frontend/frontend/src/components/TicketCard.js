import React from 'react';

const TicketCard = ({ ticket }) => {
    return (
        <div className="ticket-card">
            <h3>{ticket.event_name}</h3>
            <p>Price: ${ticket.price}</p>
            <p>Available: {ticket.quantity}</p>
        </div>
    );
};

export default TicketCard;
