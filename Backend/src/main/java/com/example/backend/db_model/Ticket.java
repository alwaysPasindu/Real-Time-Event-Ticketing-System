package com.example.backend.db_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;   // Reference to the user who purchased the ticket
    private Long eventId;  // Reference to the event
    private String ticketType;  // e.g., Regular, VIP
    private boolean isBooked;

    // Constructors, getters, setters
    public Ticket() {}

    public Ticket(Long userId, Long eventId, String ticketType, boolean isBooked) {
        this.userId = userId;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.isBooked = isBooked;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
