package com.example.BookShelf.controller;

import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.request.CiteRequest;
import com.example.BookShelf.model.response.CategoryResponse;
import com.example.BookShelf.model.response.CiteResponse;
import com.example.BookShelf.service.CategoryService;
import com.example.BookShelf.service.CiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cites")
public class CiteController {
    private final CiteService service;

    @Autowired
    public CiteController(CiteService service)
    {
        this.service = service;
    }


    @GetMapping("/")
    public List<CiteResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CiteResponse getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping("/create")
    public CiteResponse create(@RequestBody CiteRequest request) throws Exception {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public CiteResponse update(@PathVariable int id, @RequestBody CiteRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return service.delete(id);
    }
}
