import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TicketPool {
    private final List<Ticket> tickets = new CopyOnWriteArrayList<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // Add tickets (Vendor adds tickets)
    public synchronized void addTickets(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets.size() < maxCapacity) {
                tickets.add(new Ticket("Ticket-" + (tickets.size() + 1)));
            }
        }
    }

    // Remove tickets (Customer purchases tickets)
    public synchronized Ticket removeTicket() {
        if (tickets.isEmpty()) {
            return null; // No tickets available
        }
        return tickets.remove(0);
    }

    // Get the current number of tickets available
    public int getTicketCount() {
        return tickets.size();
    }

    // Get all tickets in the pool
    public List<Ticket> getTickets() {
        return tickets;
    }
}
