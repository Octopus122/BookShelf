package com.example.BookShelf.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cites")
public class Cite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id", nullable = false)
    public Book book;

    @Column(name = "text", nullable = false)
    public String text;
}
