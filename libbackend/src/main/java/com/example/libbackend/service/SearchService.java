package com.example.libbackend.service;

import com.example.libbackend.model.Book;
import com.example.libbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContainingOrGenreContaining(query, query, query);
    }
}
