package Main;

public class Ticket {
    private String ticketId;

    // Constructor to create a ticket with a unique ID
    public Ticket(String ticketId) {
        this.ticketId = ticketId;
    }

    // Getter for ticketId
    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId;
    }
}
