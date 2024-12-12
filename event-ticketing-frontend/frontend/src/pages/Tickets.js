import React, { useEffect, useState } from 'react';
import TicketCard from '../components/TicketCard';

const Tickets = () => {
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        const fetchTickets = async () => {
            const response = await fetch('/api/tickets'); // Adjust API endpoint as necessary
            const data = await response.json();
            setTickets(data);
        };

        fetchTickets();
    }, []);

    return (
        <div>
            <h2>Available Tickets</h2>
            {tickets.map(ticket => (
                <TicketCard key={ticket.id} ticket={ticket} />
            ))}
        </div>
    );
};

export default Tickets;
