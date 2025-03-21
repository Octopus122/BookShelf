package com.example.BookShelf.service;

import com.example.BookShelf.model.request.BookRequest;
import com.example.BookShelf.model.response.BookResponse;


import java.util.List;

public interface BookService {
    BookResponse getById(int id);
    List<BookResponse> getAll();
    BookResponse create (BookRequest request);
    BookResponse update (int id, BookRequest request);
    String delete (int id);
}
