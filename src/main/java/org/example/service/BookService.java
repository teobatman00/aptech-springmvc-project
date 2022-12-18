package org.example.service;

import org.example.entity.BookEntity;

import java.util.List;

public interface BookService {
    List<BookEntity> getBooks();

    void saveBook(BookEntity book);

    BookEntity getById(long id);

    void deleteBookById(long id);
}
