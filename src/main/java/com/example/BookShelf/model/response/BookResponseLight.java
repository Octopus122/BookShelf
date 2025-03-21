package com.example.BookShelf.model.response;

final public class BookResponseLight {
    private final int id;
    private final String name;
    private final String author;
    private final int rate;
    private final String opinion;
    //    public final List<Cite> cites;
    public BookResponseLight(int id, String name, String author, int rate, String opinion)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.rate = rate;
        this.opinion = opinion;
    }
    public int getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getRate()
    {
        return rate;
    }
    public String getOpinion()
    {
        return opinion;
    }
}
