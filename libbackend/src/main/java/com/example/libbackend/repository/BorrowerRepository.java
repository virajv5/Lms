package com.example.libbackend.repository;

import com.example.libbackend.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    Borrower findByEmail(String email);

    Borrower findByEmailAndPassword(String email, String password);
}