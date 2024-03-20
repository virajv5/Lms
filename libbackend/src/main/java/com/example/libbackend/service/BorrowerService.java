package com.example.libbackend.service;

import com.example.libbackend.model.Borrower;
import com.example.libbackend.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrower getBorrowerById(Long id) {
        return borrowerRepository.findById(id).orElse(null);
    }
    public List<Borrower> getAllBorrowersWithBooksBorrowed() {
        return borrowerRepository.findAll(); // This should eagerly fetch booksBorrowed
    }

    public Borrower registerBorrower(Borrower borrower) {
        // Additional business logic for registration, if needed
        return borrowerRepository.save(borrower);
    }

    public Borrower getBorrowerByEmail(String email) {
        return borrowerRepository.findByEmail(email);
    }
    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public Borrower updateBorrower(Long id, Borrower borrower) {
        if (borrowerRepository.existsById(id)) {
            borrower.setId(id);
            return borrowerRepository.save(borrower);
        }
        return null;
    }

    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }
}
