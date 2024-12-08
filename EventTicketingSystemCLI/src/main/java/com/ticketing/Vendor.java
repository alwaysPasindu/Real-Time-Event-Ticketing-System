package com.ticketing;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketReleaseRate;

    public Vendor(TicketPool ticketPool, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        while (true) {
            ticketPool.addTickets(ticketReleaseRate);
            try {
                Thread.sleep(1000); // Release tickets at the specified rate (per second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
