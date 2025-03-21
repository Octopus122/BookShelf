package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Book;
import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.entity.Cite;
import com.example.BookShelf.model.request.BookRequest;
import com.example.BookShelf.model.response.BookResponse;
import com.example.BookShelf.model.response.CiteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class BookMapper {
    private final CiteMapper citeMapper;

    @Autowired
    public BookMapper(CiteMapper citeMapper)
    {

        this.citeMapper = citeMapper;
    }

    public BookResponse entityToResponse(Book entity)
    {
        ArrayList<CiteResponse> cites = new ArrayList<CiteResponse>();
        if (entity.cites != null)
        {
            for (Cite cite: entity.cites)
            {
                cites.add(citeMapper.entityToResponse(cite));
            }
        }
        return new BookResponse(entity.id,
                entity.name,
                entity.author,
                entity.category.id,
                entity.rate,
                entity.opinion,
                Collections.unmodifiableList(cites)
                );
    }

    public Book createRequestToEntity(BookRequest request, Category category)
    {
        var entity = new Book();
        return initializeCommonFields(entity, request, category);
    }
    public Book updateRequestToEntity(Book entity, BookRequest request, Category category)
    {
        return initializeCommonFields(entity, request, category);
    }
    private Book initializeCommonFields(Book entity, BookRequest request, Category category)
    {
        entity.name = request.getName();
        entity.author = request.getAuthor();
        entity.category = category;
        entity.rate = request.getRate();
        entity.opinion = request.getOpinion();
        return entity;
    }

}
