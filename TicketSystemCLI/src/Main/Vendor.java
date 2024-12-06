package Main;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsPerRelease;
    private final int releaseInterval; // In milliseconds

    public Vendor(TicketPool ticketPool, int ticketsPerRelease, int releaseInterval) {
        this.ticketPool = ticketPool;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < ticketsPerRelease; i++) {
                    Ticket ticket = new Ticket("Ticket-" + System.currentTimeMillis()); // Unique ticket ID
                    ticketPool.addTicket(ticket); // Add to pool
                }
                Thread.sleep(releaseInterval); // Release tickets every interval
            }
        } catch (InterruptedException e) {
            System.out.println("Vendor interrupted.");
        }
    }
}
