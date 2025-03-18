package com.example.BookShelf.model.response;

final public class ColorResponse {
    private final int id;
    private final String name;
    private final String hexCode;

    public ColorResponse(int id,  String name, String hexCode)
    {
        this.id = id;
        this.name = name;
        this.hexCode = hexCode;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getHexCode()
    {
        return hexCode;
    }
}
