package com.example.sample_spring_boot.repository;

import com.example.sample_spring_boot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    // Custom query method to find by username
    Optional<Account> findByUsername(String username);

    // Custom query method to find by email
    Optional<Account> findByEmail(String email);

    // Check if a username already exists
    boolean existsByUsername(String username);
}
