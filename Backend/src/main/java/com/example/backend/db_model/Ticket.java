package com.example.backend.db_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Automatically generated ID for the ticket
    private Long userId;   // Foreign key to the User table
    private Long eventId;  // Foreign key to the Event table
    private String ticketType;  // Ticket type (e.g., VIP, Regular)
    private boolean isBooked;   // Whether the ticket is booked

    // Default constructor
    public Ticket() {}

    // Constructor with parameters
    public Ticket(Long userId, Long eventId, String ticketType, boolean isBooked) {
        this.userId = userId;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.isBooked = isBooked;
    }

    // Getters and Setters
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
