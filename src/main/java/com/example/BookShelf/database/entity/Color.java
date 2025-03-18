package com.example.BookShelf.database.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "hex_code", nullable = false)
    public String hexCode;

    //сеттеры
//    public void setId(int id)
//    {
//        this.id = id;
//    }
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public void setId(String hexCode)
//    {
//        this.hexCode = hexCode;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public String getName()
//    {
//        return name;
//    }
//    public String getId(String hexCode)
//    {
//        return hexCode;
//    }
}
