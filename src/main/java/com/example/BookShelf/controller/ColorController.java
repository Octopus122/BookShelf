package com.example.BookShelf.controller;

import com.example.BookShelf.model.request.ColorRequest;
import com.example.BookShelf.model.response.ColorResponse;
import com.example.BookShelf.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colors")
public class ColorController {
    private final ColorService service;

    @Autowired
    public ColorController(ColorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<ColorResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ColorResponse getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping("/create")
    public ColorResponse create(@RequestBody ColorRequest request) throws Exception {
        return service.create(request);
    }
    @PutMapping("/update/{id}")
    public ColorResponse update(@PathVariable int id, @RequestBody ColorRequest request) throws Exception {
        return service.update(id, request);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return service.delete(id);
    }
}
