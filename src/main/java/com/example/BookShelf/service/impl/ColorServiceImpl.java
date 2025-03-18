package com.example.BookShelf.service.impl;

import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.database.reposotory.ColorDao;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.service.ColorService;
import com.example.BookShelf.util.mapper.ColorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ColorResponse create(ColorRequest request) {
        var entity = mapper.createRequestToEntity(request);
        return mapper.entityToResponse(dao.save(entity));
    }

    @Override
    public ColorResponse update(int id, ColorRequest request) {
        return null;
    }

    @Override
    public ColorResponse delete(int id) {
        return null;
    }
}
