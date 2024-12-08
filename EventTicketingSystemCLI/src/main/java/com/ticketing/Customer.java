package com.ticketing;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    @Override
    public void run() {
        while (true) {
            Ticket ticket = ticketPool.removeTicket();
            if (ticket != null) {
                // Simulate the customer "buying" the ticket
                System.out.println("Customer bought ticket ID: " + ticket.getId());
            }
            try {
                Thread.sleep(1000); // Try to purchase tickets at the specified rate (per second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}