package com.example.BookShelf.model.response;

import java.util.List;

public record BookResponse(
        int id,
        String name,
        String author,
        int category_id,
        int rate,
        String opinion,
        List<CiteResponse> cites) {
}
