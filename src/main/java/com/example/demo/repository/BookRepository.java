package com.example.demo.repository;

import com.example.demo.entities.Book;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
        }
