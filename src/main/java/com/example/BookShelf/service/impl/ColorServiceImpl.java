package com.example.BookShelf.service.impl;

import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.database.reposotory.ColorDao;
import com.example.BookShelf.exception.types.CantFindElementById;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.service.ColorService;
import com.example.BookShelf.util.mapper.ColorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.StreamSupport;

@Service
public class ColorServiceImpl implements ColorService {


    private final ColorDao dao;
    private final ColorMapper mapper;

    @Autowired
    public ColorServiceImpl(ColorDao dao, ColorMapper mapper)
    {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public ColorResponse getById(int id) {
        return null;
    }

    @Override
    public List<ColorResponse> getAll() {
        ArrayList<ColorResponse> list = new  ArrayList<ColorResponse>();
        for (Color color: dao.findAll())
        {
            list.add(mapper.entityToResponse(color));
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public ColorResponse create(ColorRequest request) throws Exception {
        var entity = mapper.createRequestToEntity(request);
        return mapper.entityToResponse(dao.save(entity));

    }

    @Override
    public ColorResponse update(int id, ColorRequest request) throws Exception {
            var entity = dao.findById(id).orElseThrow(() -> new CantFindElementById("color"));
            entity = mapper.updateRequestToEntity(entity, request);
            return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public String delete(int id) {
        var entity = dao.findById(id).orElseThrow(() -> new CantFindElementById("color"));
        dao.delete(entity);
        return "Color is successfully deleted";

    }
}
