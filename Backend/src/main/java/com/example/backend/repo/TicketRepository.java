package com.example.backend.repo;

import com.example.backend.db_model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // No custom queries needed for basic CRUD
}
