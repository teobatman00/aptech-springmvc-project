package org.example.mapper;

import org.example.entity.BookEntity;
import org.example.request.book.BookCreateRequest;
import org.example.request.book.BookUpdateRequest;

public interface BookMapper {
    BookEntity mapCreateRequestToEntity(BookCreateRequest bookCreateRequest);

    BookUpdateRequest mapEntityToUpdateRequest(BookEntity book);

    BookEntity mapUpdateRequestToEntity(BookUpdateRequest bookUpdateRequest, BookEntity book);
}
