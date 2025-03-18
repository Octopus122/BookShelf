package com.example.BookShelf.model.response;

final public class CategoryResponse {
    final private int id;
    final private String name;
    final private ColorResponse color;
//    final private List<>

    public CategoryResponse(int id, String name, ColorResponse color)
    {
        this.id = id;
        this.color = color;
        this.name = name;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public ColorResponse getColor()
    {
        return color;
    }
}
