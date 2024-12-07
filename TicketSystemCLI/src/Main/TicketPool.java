package Main;

import java.util.List;

public class TicketPool {
    private final List<Ticket> tickets;
    private final int maxCapacity;

    // Constructor
    public TicketPool(List<Ticket> tickets, int maxCapacity) {
        this.tickets = tickets;
        this.maxCapacity = maxCapacity;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
