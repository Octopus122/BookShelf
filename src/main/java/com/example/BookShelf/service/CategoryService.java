package com.example.BookShelf.service;

import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getById(int id);
    List<CategoryResponse> getAll();
    CategoryResponse create (CategoryRequest request);
    CategoryResponse update (int id, CategoryRequest request);
    String delete (int id);
}
