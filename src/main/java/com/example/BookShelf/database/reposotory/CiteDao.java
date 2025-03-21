package com.example.BookShelf.database.reposotory;

import com.example.BookShelf.database.entity.Cite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiteDao extends CrudRepository<Cite, Integer> {
}
