package com.example.BookShelf.util.mapper;

import com.example.BookShelf.database.entity.Color;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.util.validator.HexCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    private final HexCodeMapper codeMapper;

    @Autowired
    public ColorMapper(HexCodeMapper codeMapper)
    {
        this.codeMapper = codeMapper;
    }
    public Color createRequestToEntity(ColorRequest request) throws Exception {
        var entity = new Color();
        entity.name = request.getName();
        entity.hexCode = codeMapper.mapHexCode(request.getHexCode());
        return entity;
    }
    public Color updateRequestToEntity(int id, ColorRequest request) throws Exception {
        var entity = createRequestToEntity(request);
        entity.id = id;
        return entity;
    }
    public ColorResponse entityToResponse(Color entity)
    {
        return new ColorResponse(entity.id, entity.name, entity.hexCode);
    }
}
