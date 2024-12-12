// src/api.js
import axios from 'axios';

// Replace with your actual backend URL
const BASE_URL = 'http://localhost:5000/api'; // Change this to your backend URL

// Fetch events list
export const getEvents = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/events`);
    return response.data; // List of events
  } catch (error) {
    console.error('Error fetching events:', error);
    throw error;
  }
};

// Get event details (tickets available)
export const getEventDetails = async (eventId) => {
  try {
    const response = await axios.get(`${BASE_URL}/events/${eventId}`);
    return response.data; // Event details
  } catch (error) {
    console.error('Error fetching event details:', error);
    throw error;
  }
};

// Create a new event
export const createEvent = async (newEvent) => {
  try {
    const response = await axios.post(`${BASE_URL}/events`, newEvent);
    return response.data; // Newly created event data
  } catch (error) {
    console.error('Error creating event:', error);
    throw error;
  }
};

// Book a ticket for an event
export const bookTicket = async (bookingData) => {
  try {
    const response = await axios.post(`${BASE_URL}/book-ticket`, bookingData);
    return response.data; // Booking confirmation data
  } catch (error) {
    console.error('Error booking ticket:', error);
    throw error;
  }
};
