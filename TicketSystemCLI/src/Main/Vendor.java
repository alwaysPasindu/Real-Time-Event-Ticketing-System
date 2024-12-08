public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketReleaseRate; // Number of tickets released per second

    public Vendor(TicketPool ticketPool, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ticketPool.addTickets(ticketReleaseRate);  // Vendor adds tickets to the pool
                System.out.println("Vendor added " + ticketReleaseRate + " tickets.");
                Thread.sleep(1000);  // Wait for 1 second before adding more tickets
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
