package com.example.backend.repo;

import com.example.backend.db_model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    // No custom queries needed for basic CRUD
}
