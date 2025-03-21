package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Book;
import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.response.BookResponseLight;
import com.example.BookShelf.model.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CategoryMapper {
    private final ColorMapper colorMapper;

    @Autowired
    public CategoryMapper(ColorMapper colorMapper)
    {
        this.colorMapper = colorMapper;
    }

    public CategoryResponse entityToResponse(Category entity)
    {
        ArrayList<BookResponseLight> books = new ArrayList<>();
        if (entity.books != null) {
            for (Book book : entity.books) {
                books.add(entityToResponseBook(book));
            }
        }
        return new CategoryResponse(entity.id,
                entity.name,
                colorMapper.entityToResponse(entity.color),
                Collections.unmodifiableList(books)
        );
    }

    public Category createRequestToEntity(CategoryRequest request, Color color)
    {
        var entity = new Category();
        entity.name = request.getName();
        entity.color = color;
        return entity;
    }
    public Category updateRequestToEntity(Category entity, CategoryRequest request, Color color)
    {
        entity.name = request.getName();
        entity.color = color;
        return entity;
    }
    public BookResponseLight entityToResponseBook(Book entity)
    {
        return new BookResponseLight(entity.id,
                entity.name,
                entity.author,
                entity.rate,
                entity.opinion);
    }
}
