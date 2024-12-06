package Main;

import java.util.LinkedList;

public class TicketPool {
    private final LinkedList<Ticket> tickets = new LinkedList<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // Add ticket to the pool (vendor side)
    public synchronized void addTicket(Ticket ticket) throws InterruptedException {
        while (tickets.size() >= maxCapacity) {
            wait(); // Wait if the pool is at capacity
        }
        tickets.add(ticket);
        System.out.println("Ticket added: " + ticket);
        notifyAll(); // Notify customers waiting for tickets
    }

    // Remove ticket from the pool (customer side)
    public synchronized Ticket removeTicket() throws InterruptedException {
        while (tickets.isEmpty()) {
            wait(); // Wait if the pool is empty
        }
        Ticket ticket = tickets.removeFirst();
        System.out.println("Ticket purchased: " + ticket);
        notifyAll(); // Notify vendors waiting to add tickets
        return ticket;
    }

    // Get the current number of tickets in the pool
    public int size() {
        return tickets.size();
    }
}
