package com.example.BookShelf.model.request;

final public class ColorRequest {
    public final String name;
    public final String hexCode;

    public ColorRequest( String name, String hexCode)
    {
        this.name = name;
        this.hexCode = hexCode;
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
