package com.example.BookShelf.model.response;

import java.util.List;

public record CategoryResponse(int id,
                               String name,
                               ColorResponse color,
                               List<BookResponseLight> books
) {
}
