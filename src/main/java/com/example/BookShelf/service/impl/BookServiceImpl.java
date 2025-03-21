package com.example.BookShelf.service.impl;

import com.example.BookShelf.database.entity.Book;
import com.example.BookShelf.database.entity.Category;
import com.example.BookShelf.database.reposotory.BookDao;
import com.example.BookShelf.database.reposotory.CategoryDao;
import com.example.BookShelf.exception.types.CantFindElementById;
import com.example.BookShelf.model.request.BookRequest;
import com.example.BookShelf.model.response.BookResponse;
import com.example.BookShelf.model.response.CategoryResponse;
import com.example.BookShelf.service.BookService;
import com.example.BookShelf.util.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;
    private final BookMapper mapper;
    private final CategoryDao categoryDao;

    @Autowired
    public BookServiceImpl( BookDao dao, BookMapper mapper, CategoryDao categoryDao)
    {
        this.dao = dao;
        this.mapper = mapper;
        this.categoryDao = categoryDao;
    }

    @Override
    public BookResponse getById(int id) {
        return mapper.entityToResponse(dao.findById(id).orElseThrow(()-> new CantFindElementById("book")));
    }

    @Override
    public List<BookResponse> getAll() {
        ArrayList<BookResponse> list = new  ArrayList<BookResponse>();
        for (Book book: dao.findAll())
        {
            list.add(mapper.entityToResponse(book));
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public BookResponse create(BookRequest request) {
        var category = categoryDao.findById(request.getCategoryId()).orElseThrow(()-> new CantFindElementById("category"));
        var entity = mapper.createRequestToEntity(request, category);
        return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public BookResponse update(int id, BookRequest request) {
        var category = categoryDao.findById(request.getCategoryId()).orElseThrow(()-> new CantFindElementById("category"));
        var entity = mapper.updateRequestToEntity(dao.findById(id).orElseThrow(()-> new CantFindElementById("book")),
                request,
                category);
        return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public String delete(int id) {
        var entity = dao.findById(id).orElseThrow(()-> new CantFindElementById("book"));
        dao.delete(entity);
        return "Book is successfully deleted";
    }
}
