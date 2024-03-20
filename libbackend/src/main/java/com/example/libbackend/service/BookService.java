package com.example.libbackend.service;

import com.example.libbackend.model.Book;
import com.example.libbackend.model.Borrower;
import com.example.libbackend.repository.BookRepository;
import com.example.libbackend.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
@Autowired
private BorrowerRepository borrowerRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContainingOrGenreContaining(query, query, query);
    }
    public Book borrowBook(Long id, Borrower borrower) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.isAvailable()) {
                // Find the borrower ID by email and password
                Borrower existingBorrower = borrowerRepository.findByEmailAndPassword(borrower.getEmail(), borrower.getPassword());
                if (existingBorrower != null) {
                    book.setAvailable(false); // Mark the book as unavailable
                    book.setBorrowerrId(existingBorrower.getId()); // Set the borrower ID for the book
                    existingBorrower.setbookid(book.getId()); // Set the book ID for the borrower
                    return bookRepository.save(book);
                } else {
                    // Borrower not found or password does not match
                    return null;
                }
            } else {
                // Book is already borrowed
                return null;
            }
        } else {
            // Book not found
            return null;
        }
    }



}
