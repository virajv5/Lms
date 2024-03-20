package com.example.libbackend.repository;

import com.example.libbackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIdAndAvailableTrue(Long id);
    List<Book> findByTitleContainingOrAuthorContainingOrGenreContaining(String title, String author, String genre);
}
