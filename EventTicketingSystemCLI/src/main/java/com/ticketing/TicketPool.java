package com.ticketing;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<Ticket> tickets;
    private final int maxTicketCapacity;

    public TicketPool(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.tickets = new LinkedList<>();
    }

    // Method to add tickets (used by the vendor)
    public synchronized void addTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            if (tickets.size() < maxTicketCapacity) {
                tickets.add(new Ticket());
                System.out.println("Ticket added to pool. Pool size: " + tickets.size());
            }
        }
    }

    // Method to remove tickets (used by the customer)
    public synchronized Ticket removeTicket() {
        if (!tickets.isEmpty()) {
            Ticket ticket = tickets.poll();
            System.out.println("Ticket purchased. Pool size: " + tickets.size());
            return ticket;
        } else {
            System.out.println("No tickets available for purchase.");
            return null;
        }
    }

    public synchronized int getTicketCount() {
        return tickets.size();
    }
}