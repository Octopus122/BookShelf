package com.example.BookShelf.model.response;

public class BookResponse {
    private final int id;
    private final String name;
    private final String author;
    private final CategoryResponse category;
    private final int rate;
    private final String opinion;
    //    public final List<Cite> cites;
    BookResponse(int id, String name, String author, CategoryResponse category, int rate, String opinion)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
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
    public CategoryResponse getCategory()
    {
        return category;
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
