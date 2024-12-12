// src/components/EventDetails.js
import React, { useEffect, useState } from 'react';
import { getEventDetails, bookTicket } from '../api';
import { useParams } from 'react-router-dom';

const EventDetails = () => {
  const { eventId } = useParams();
  const [event, setEvent] = useState(null);
  const [ticketQuantity, setTicketQuantity] = useState(1);

  useEffect(() => {
    const fetchEventDetails = async () => {
      try {
        const eventDetails = await getEventDetails(eventId);
        setEvent(eventDetails);
      } catch (error) {
        console.error('Error fetching event details', error);
      }
    };
    fetchEventDetails();
  }, [eventId]);

  const handleBooking = async () => {
    try {
      const bookingData = { eventId, quantity: ticketQuantity };
      const result = await bookTicket(bookingData);
      alert(`Booking successful! Confirmation: ${result.confirmationNumber}`);
    } catch (error) {
      alert('Error booking tickets');
    }
  };

  if (!event) {
    return <div>Loading event details...</div>;
  }

  return (
    <div>
      <h2>{event.name}</h2>
      <p>{event.date}</p>
      <p>{event.venue}</p>
      <p>{event.ticketsAvailable} tickets available</p>
      <label>
        Tickets:
        <input
          type="number"
          value={ticketQuantity}
          min="1"
          max={event.ticketsAvailable}
          onChange={(e) => setTicketQuantity(e.target.value)}
        />
      </label>
      <button onClick={handleBooking}>Book Tickets</button>
    </div>
  );
};

export default EventDetails;
