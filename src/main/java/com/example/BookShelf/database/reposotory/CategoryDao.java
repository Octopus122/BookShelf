package com.example.BookShelf.database.reposotory;

import com.example.BookShelf.database.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
