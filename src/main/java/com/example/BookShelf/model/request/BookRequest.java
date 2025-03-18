package com.example.BookShelf.model.request;

public final class BookRequest {
    private final String name;
    private final String author;
    private final int categoryId;
    private final int rate;
    private final String opinion;
//    public final List<Cite> cites;
    BookRequest(String name, String author, int categoryId, int rate, String opinion)
    {
        this.name = name;
        this.author = author;
        this.categoryId = categoryId;
        this.rate = rate;
        this.opinion = opinion;
    }
    public String getName() {
        return name;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getCategoryId()
    {
        return categoryId;
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
