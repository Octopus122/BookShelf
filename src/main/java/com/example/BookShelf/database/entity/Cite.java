package com.example.BookShelf.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cites")
public class Cite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "text", nullable = false)
    private String text;
}
