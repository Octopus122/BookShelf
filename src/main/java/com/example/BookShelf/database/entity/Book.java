package com.example.BookShelf.database.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "rate")
    private float rate;

    @Column(name = "opinion")
    private String opinion;

    @OneToMany
    private List<Cite> cites;
}
