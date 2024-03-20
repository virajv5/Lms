package com.example.libbackend.controller;

import com.example.libbackend.model.Borrower;
import com.example.libbackend.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping("/withBooks")
    public List<Borrower> getAllBorrowersWithBooksBorrowed() {
        return borrowerService.getAllBorrowersWithBooksBorrowed();
    }

    @GetMapping("/alll")
    public List<Borrower> getAllBorrowers() {
        return borrowerService.getAllBorrowers(); // Use the existing method to retrieve all borrowers
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable Long id) {
        Borrower borrower = borrowerService.getBorrowerById(id);
        if (borrower != null) {
            return ResponseEntity.ok(borrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower borrower) {
        Borrower savedBorrower = borrowerService.addBorrower(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBorrower);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @RequestBody Borrower borrower) {
        Borrower updatedBorrower = borrowerService.updateBorrower(id, borrower);
        if (updatedBorrower != null) {
            return ResponseEntity.ok(updatedBorrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Borrower> registerBorrower(@RequestBody Borrower borrower) {
        Borrower registeredBorrower = borrowerService.registerBorrower(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredBorrower);
    }

    @PostMapping("/get/{email}")
    public ResponseEntity<Borrower> getBorrowerByEmail(@PathVariable String email) {
        Borrower borrower = borrowerService.getBorrowerByEmail(email);
        if (borrower != null) {
            return ResponseEntity.ok(borrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBorrower(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        return ResponseEntity.noContent().build();
    }
}
