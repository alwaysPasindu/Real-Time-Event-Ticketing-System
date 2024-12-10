package com.example.backend.repo;

import com.example.backend.db_model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Custom queries for tickets can be added here
}
