package Main;

import java.util.concurrent.atomic.AtomicLong;

public class Ticket {
    private static final AtomicLong counter = new AtomicLong();
    private final String ticketId;

    // Constructor
    public Ticket() {
        this.ticketId = "Ticket-" + counter.incrementAndGet();
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId;
    }
}
