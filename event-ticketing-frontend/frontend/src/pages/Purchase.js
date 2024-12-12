import React, { useState } from 'react';

const Purchase = () => {
    const [ticketId, setTicketId] = useState('');
    const [quantity, setQuantity] = useState(1);

    const handlePurchase = async (e) => {
        e.preventDefault();
        const response = await fetch('/api/tickets/purchase', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ ticketId, quantity }),
        });

        if (response.ok) {
            alert('Purchase successful!');
        } else {
            alert('Purchase failed!');
        }
    };

    return (
        <form onSubmit={handlePurchase}>
            <h2>Purchase Ticket</h2>
            <input type="text" placeholder="Ticket ID" value={ticketId} onChange={(e) => setTicketId(e.target.value)} required />
            <input type="number" value={quantity} min="1" onChange={(e) => setQuantity(e.target.value)} required />
            <button type="submit">Buy Ticket</button>
        </form>
    );
};

export default Purchase;
