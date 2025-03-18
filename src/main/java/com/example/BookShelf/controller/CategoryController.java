package com.example.BookShelf.controller;

import com.example.BookShelf.model.request.CategoryRequest;
import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.CategoryResponse;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service)
    {
        this.service = service;
    }


    @GetMapping("/")
    public List<CategoryResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping("/create")
    public CategoryResponse create(@RequestBody CategoryRequest request) throws Exception {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public CategoryResponse update(@PathVariable int id, @RequestBody CategoryRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return service.delete(id);
    }
}
