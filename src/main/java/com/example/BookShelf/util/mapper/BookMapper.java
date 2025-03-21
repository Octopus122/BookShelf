package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Book;
import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.model.request.BookRequest;
import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.response.BookResponse;
import com.example.BookShelf.model.response.BookResponseLight;
import com.example.BookShelf.model.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final CategoryMapper categoryMapper;

    @Autowired
    public BookMapper(CategoryMapper categoryMapper)
    {
        this.categoryMapper = categoryMapper;
    }

    public BookResponse entityToResponse(Book entity)
    {
        return new BookResponse(entity.id,
                entity.name,
                entity.author,
                categoryMapper.entityToResponse(entity.category),
                entity.rate,
                entity.opinion);
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
