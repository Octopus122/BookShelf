package com.example.BookShelf.database.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name = "author")
    public String author;

    @Column(name = "name", nullable = false)
    public String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;

    @Column(name = "rate")
    public int rate;

    @Column(name = "opinion")
    public String opinion;

    @OneToMany
    public List<Cite> cites;
}
