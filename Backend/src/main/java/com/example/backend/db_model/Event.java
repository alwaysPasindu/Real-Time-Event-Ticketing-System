package com.example.backend.db_model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Automatically generated ID for the event
    private String name;
    private LocalDateTime eventDate;
    private String location;
    private int totalTickets;

    // Default constructor
    public Event() {}

    // Constructor with parameters
    public Event(String name, LocalDateTime eventDate, String location, int totalTickets) {
        this.name = name;
        this.eventDate = eventDate;
        this.location = location;
        this.totalTickets = totalTickets;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
}
