import axios from 'axios';

const API_URL = 'http://localhost:3000/api/tickets';

export const getTickets = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching tickets:', error);
    throw error;
  }
};

export const purchaseTicket = async (ticketId, quantity) => {
  try {
    const response = await axios.post(`${API_URL}/purchase`, {
      ticketId,
      quantity,
    });
    return response.data;
  } catch (error) {
    console.error('Error purchasing ticket:', error);
    throw error;
  }
};
