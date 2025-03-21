package com.example.BookShelf.controller;

import com.example.BookShelf.model.request.BookRequest;
import com.example.BookShelf.model.response.BookResponse;
import com.example.BookShelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service)
    {
        this.service = service;
    }


    @GetMapping("/")
    public List<BookResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping("/create")
    public BookResponse create(@RequestBody BookRequest request) throws Exception {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public BookResponse update(@PathVariable int id, @RequestBody BookRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return service.delete(id);
    }
}
