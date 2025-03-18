package com.example.BookShelf.exception.types;

public class WrongHEXCode extends RuntimeException {
    public WrongHEXCode(String message) {
        super("Wrong HEX code! "+message );
    }
}
