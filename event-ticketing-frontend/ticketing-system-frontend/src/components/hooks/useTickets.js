import { useState, useEffect } from 'react';
import TicketService from '../services/TicketService';

const useTickets = () => {
  const [tickets, setTickets] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchTickets = async () => {
    try {
      setLoading(true);
      const data = await TicketService.fetchTickets();
      setTickets(data);
      setError(null);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchTickets();
  }, []);

  return { 
    tickets, 
    loading, 
    error, 
    refetch: fetchTickets 
  };
};

export default useTickets;
