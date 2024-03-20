package com.example.libbackend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long bookid;
    private String password; // New field
    private String name;
    @Column(nullable = false)
    private String email;
    private String contactNumber;

    @OneToMany(mappedBy = "borrower", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> booksBorrowed;


    public Borrower() {
    }

    public Borrower(String name, String email, String contactNumber) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", booksBorrowed=" + booksBorrowed +
                '}';
    }

    public void setbookid(Long id) {
        this.bookid = id;
    }
    public long getbookid() {
        return bookid;
    }
}
