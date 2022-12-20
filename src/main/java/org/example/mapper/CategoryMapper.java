package org.example.mapper;

import org.example.entity.CategoryEntity;
import org.example.request.category.CategoryCreateRequest;

public interface CategoryMapper {
    CategoryEntity mapCreateRequestToEntity(CategoryCreateRequest categoryCreateRequest);
}
