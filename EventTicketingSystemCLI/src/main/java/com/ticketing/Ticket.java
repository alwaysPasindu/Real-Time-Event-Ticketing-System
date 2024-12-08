package com.ticketing;

public class Ticket {
    private static int idCounter = 0;
    private int id;

    public Ticket() {
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }
}