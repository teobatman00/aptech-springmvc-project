package org.example.mapper;

import org.example.entity.BookEntity;
import org.example.request.book.BookCreateRequest;
import org.example.request.book.BookUpdateRequest;
import org.example.response.BookGetDetailResponse;
import org.example.response.BookGetListResponse;

import java.io.IOException;

public interface BookMapper {
    BookEntity mapCreateRequestToEntity(BookCreateRequest bookCreateRequest);

    BookUpdateRequest mapEntityToUpdateRequest(BookEntity book);

    BookEntity mapUpdateRequestToEntity(BookUpdateRequest bookUpdateRequest, BookEntity book) throws IOException;

    BookGetListResponse mapEntityToGetListResponse(BookEntity bookEntity);

    BookGetDetailResponse mapEntityToDetailResponse(BookEntity book);
}
