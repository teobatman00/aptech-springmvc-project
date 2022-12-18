package org.example.service.impl;

import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getBooks() {
        return bookRepository.getList();
    }

    @Override
    public void saveBook(BookEntity book) {
        bookRepository.save(book);
    }

    @Override
    public BookEntity getById(long id) {
        return bookRepository.getById(id);
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

}
