// src/components/EventList.js
import React, { useEffect, useState } from 'react';
import { getEvents } from '../api';
import { Link } from 'react-router-dom';

const EventList = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const eventsData = await getEvents();
        setEvents(eventsData);
      } catch (error) {
        console.error('Error fetching events', error);
      }
    };
    fetchEvents();
  }, []);

  return (
    <div>
      <h2>Available Events</h2>
      <ul>
        {events.map((event) => (
          <li key={event.id}>
            <Link to={`/event/${event.id}`}>{event.name}</Link> - {event.date} - {event.ticketsAvailable} tickets available
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EventList;
