package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Book;
import com.example.BookShelf.database.entity.Cite;
import com.example.BookShelf.model.request.CiteRequest;
import com.example.BookShelf.model.response.CiteResponse;
import org.springframework.stereotype.Component;

@Component
public class CiteMapper {
    public CiteResponse entityToResponse(Cite entity)
    {
        return new CiteResponse(
                entity.id,
                entity.book.id,
                entity.text
        );
    }
    public Cite createRequestToEntity(CiteRequest request, Book book)
    {
        var entity = new Cite();
        entity.book = book;
        entity.text = request.text();
        return entity;
    }
    public Cite updateRequestToEntity(Cite entity, CiteRequest request, Book book)
    {
        entity.book = book;
        entity.text = request.text();
        return entity;
    }

}
