package com.example.BookShelf.service.impl;

import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.database.reposotory.CategoryDao;
import com.example.BookShelf.database.reposotory.ColorDao;
import com.example.BookShelf.exception.types.CantFindElementById;
import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.response.CategoryResponse;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.service.CategoryService;
import com.example.BookShelf.util.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao  dao;
    private final CategoryMapper mapper;
    private final ColorDao colorDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao  dao, CategoryMapper mapper, ColorDao colorDao)
    {
        this.dao = dao;
        this.mapper = mapper;
        this.colorDao = colorDao;
    }

    @Override
    public CategoryResponse getById(int id) {
        var entity = dao.findById(id).orElseThrow(()->new CantFindElementById("category"));
        return mapper.entityToResponse(entity);
    }

    @Override
    public List<CategoryResponse> getAll() {
        ArrayList<CategoryResponse> list = new  ArrayList<CategoryResponse>();
        for (Category category: dao.findAll())
        {
            list.add(mapper.entityToResponse(category));
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        var color = colorDao.findById(request.getColorId()).orElseThrow(()-> new CantFindElementById("color"));
        var entity = new Category();
        entity.name = request.getName();
        entity.color = color;
        return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public CategoryResponse update(int id, CategoryRequest request) {
        var color = colorDao.findById(request.getColorId()).orElseThrow(()-> new CantFindElementById("color"));
        var entity = dao.findById(id).orElseThrow(()-> new CantFindElementById("category"));
        entity.name = request.getName();
        entity.color = color;
        return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public String delete(int id) {
        var entity = dao.findById(id).orElseThrow(()-> new CantFindElementById("category"));
        dao.delete(entity);
        return "Category is successfully deleted";
    }
}
