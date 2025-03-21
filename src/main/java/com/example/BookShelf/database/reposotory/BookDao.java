package com.example.BookShelf.database.reposotory;

import com.example.BookShelf.database.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {
}
