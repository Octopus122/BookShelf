package com.example.BookShelf.service;

import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.model.request.ColorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ColorService {
    public ColorResponse getById(int id);
    public List<ColorResponse> getAll();
    public ColorResponse create(ColorRequest request) throws Exception;
    public ColorResponse update(int id, ColorRequest request) throws Exception;
    public String delete (int id);

}
