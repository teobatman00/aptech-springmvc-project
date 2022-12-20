package org.example.mapper.impl;

import org.example.entity.BookEntity;
import org.example.mapper.BookMapper;
import org.example.request.book.BookCreateRequest;
import org.example.request.book.BookUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity mapCreateRequestToEntity(BookCreateRequest bookCreateRequest) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookEntity.getName());
        bookEntity.setDescription(bookEntity.getDescription());
        bookEntity.setAuthor(bookEntity.getAuthor());
        bookEntity.setAvatar(bookEntity.getAvatar());
        bookEntity.setPublishedDate(bookCreateRequest.getPublishedDate());
        return bookEntity;
    }

    @Override
    public BookUpdateRequest mapEntityToUpdateRequest(BookEntity book) {
        BookUpdateRequest bookUpdateRequest = new BookUpdateRequest();
        bookUpdateRequest.setName(book.getName());
        bookUpdateRequest.setDescription(book.getDescription());
        bookUpdateRequest.setAuthor(book.getAuthor());
        bookUpdateRequest.setPublished(book.isPublished());
        bookUpdateRequest.setAvatar(book.getAvatar());
        return bookUpdateRequest;
    }

    @Override
    public BookEntity mapUpdateRequestToEntity(BookUpdateRequest bookUpdateRequest, BookEntity book) {
        book.setName(bookUpdateRequest.getName());
        book.setDescription(bookUpdateRequest.getDescription());
        book.setAuthor(bookUpdateRequest.getAuthor());
        book.setPublished(book.isPublished());
        book.setAvatar(book.getAvatar());
        return book;
    }
}
