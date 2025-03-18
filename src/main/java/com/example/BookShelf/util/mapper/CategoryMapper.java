package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.CategoryResponse;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return new CategoryResponse(entity.id, entity.name, colorMapper.entityToResponse(entity.color));
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
}
