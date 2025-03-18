package com.example.BookShelf.exception.resolver;

import com.example.BookShelf.exception.model.ExceptionData;
import com.example.BookShelf.exception.types.CantFindElementById;
import com.example.BookShelf.exception.types.WrongHEXCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLException;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(WrongHEXCode.class)
    public ExceptionData wrongHexCode(WrongHEXCode exception)
    {
        return new ExceptionData(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CantFindElementById.class)
    public ExceptionData catFindById(CantFindElementById exception)
    {
        return new ExceptionData(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
