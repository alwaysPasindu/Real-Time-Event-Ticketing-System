class TicketService {
    // Centralized service for ticket-related API interactions
    static async fetchTickets() {
      try {
        const response = await fetch('/api/tickets');
        if (!response.ok) {
          throw new Error('Failed to fetch tickets');
        }
        return await response.json();
      } catch (error) {
        console.error('Error fetching tickets:', error);
        throw error;
      }
    }
  
    static async addTicket(ticketData) {
      try {
        const response = await fetch('/api/tickets', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(ticketData)
        });
  
        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.error || 'Failed to add ticket');
        }
  
        return await response.json();
      } catch (error) {
        console.error('Error adding ticket:', error);
        throw error;
      }
    }
  
    static async purchaseTicket(purchaseData) {
      try {
        const response = await fetch('/api/tickets/purchase', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(purchaseData)
        });
  
        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.error || 'Failed to purchase ticket');
        }
  
        return await response.json();
      } catch (error) {
        console.error('Error purchasing ticket:', error);
        throw error;
      }
    }
  }
  
  export default TicketService;