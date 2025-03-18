package com.example.BookShelf.model.request;

final public class CategoryRequest {
    final private String name;
    final private int colorId;

    public CategoryRequest(String name, int colorId)
    {
        this.colorId = colorId;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getColorId()
    {
        return colorId;
    }
}
