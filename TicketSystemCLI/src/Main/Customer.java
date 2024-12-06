package Main;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int purchaseInterval; // In milliseconds

    public Customer(TicketPool ticketPool, int purchaseInterval) {
        this.ticketPool = ticketPool;
        this.purchaseInterval = purchaseInterval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ticket ticket = ticketPool.removeTicket(); // Try to purchase a ticket
                System.out.println("Customer bought: " + ticket);
                Thread.sleep(purchaseInterval); // Try to buy again after the specified interval
            }
        } catch (InterruptedException e) {
            System.out.println("Customer interrupted.");
        }
    }
}
