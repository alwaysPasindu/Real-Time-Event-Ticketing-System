package com.example.backend.repo;

import com.example.backend.db_model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // No custom queries needed for basic CRUD
}
