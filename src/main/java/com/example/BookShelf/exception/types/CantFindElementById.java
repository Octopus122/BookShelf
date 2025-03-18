package com.example.BookShelf.exception.types;

public class CantFindElementById extends RuntimeException {
    public CantFindElementById(String message) {
        super("Cant find element by id. Element type: "+message);
    }
}
