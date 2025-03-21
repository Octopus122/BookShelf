package com.example.BookShelf.service;

import com.example.BookShelf.model.request.CiteRequest;
import com.example.BookShelf.model.response.CiteResponse;

import java.util.List;

public interface CiteService {
    CiteResponse getById(int id);
    List<CiteResponse> getAll();
    CiteResponse create(CiteRequest request);
    CiteResponse update(int id, CiteRequest request);
    String delete(int id);
}
