package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.ColorResponse;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {
    public Color createRequestToEntity(ColorRequest request)
    {
        var entity = new Color();
        entity.name = request.getName();
        entity.hexCode = request.getHexCode();
        return entity;
    }
    public Color updateRequestToEntity(int id, ColorRequest request)
    {
        var entity = createRequestToEntity(request);
        entity.id = id;
        return entity;
    }
    public ColorResponse entityToResponse(Color entity)
    {
        return new ColorResponse(entity.id, entity.name, entity.hexCode);
    }
}
