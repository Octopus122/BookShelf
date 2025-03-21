package com.example.BookShelf.service.impl;

import com.example.BookShelf.database.entity.Cite;
import com.example.BookShelf.database.reposotory.BookDao;
import com.example.BookShelf.database.reposotory.CiteDao;
import com.example.BookShelf.exception.types.CantFindElementById;
import com.example.BookShelf.model.request.CiteRequest;
import com.example.BookShelf.model.response.CiteResponse;
import com.example.BookShelf.service.CiteService;
import com.example.BookShelf.util.mapper.CiteMapper;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CiteServiceImpl implements CiteService {
    private final CiteDao dao;
    private final CiteMapper mapper;
    private final BookDao bookDao;

    @Autowired
    public CiteServiceImpl(CiteDao dao, CiteMapper mapper, BookDao bookDao)
    {
        this.dao = dao;
        this.mapper = mapper;
        this.bookDao = bookDao;
    }

    @Override
    public CiteResponse getById(int id) {
        return mapper.entityToResponse(dao.findById(id).orElseThrow(()-> new CantFindElementById("cite")));
    }

    @Override
    public List<CiteResponse> getAll() {
        ArrayList<CiteResponse> list = new ArrayList<CiteResponse>();
        for (Cite cite: dao.findAll())
        {
            list.add(mapper.entityToResponse(cite));
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public CiteResponse create(CiteRequest request) {
        var book = bookDao.findById(request.book_id()).orElseThrow(()-> new CantFindElementById("book"));
        return mapper.entityToResponse(dao.save(mapper.createRequestToEntity(request, book)));
    }

    @Override
    public CiteResponse update(int id, CiteRequest request) {
        var entity = dao.findById(id).orElseThrow(()->new CantFindElementById("cite"));
        var book = bookDao.findById(id).orElseThrow(()->new CantFindElementById("book"));
        return mapper.entityToResponse(dao.save(mapper.updateRequestToEntity(entity, request, book)));
    }

    @Override
    public String delete(int id) {
        var entity = dao.findById(id).orElseThrow(()-> new CantFindElementById("cite"));
        dao.delete(entity);
        return "Category is successfully deleted";
    }

//    public
}
