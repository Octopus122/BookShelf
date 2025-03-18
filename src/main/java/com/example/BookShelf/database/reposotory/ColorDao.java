package com.example.BookShelf.database.reposotory;

import com.example.BookShelf.database.entity.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorDao extends CrudRepository<Color, Integer> {
}
