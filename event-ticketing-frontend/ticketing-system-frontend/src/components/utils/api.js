// src/services/api.js
import axios from 'axios';

const API_URL = 'http://localhost:3000'; // Adjust based on your backend URL

export const fetchTickets = async () => {
    const response = await axios.get(API_URL);
    return response.data;
};

export const purchaseTicket = async (ticketId, quantity) => {
    const response = await axios.post(`${API_URL}/purchase`, { ticketId, quantity });
    return response.data;
};
