package org.example.mapper;

import org.example.entity.CategoryEntity;
import org.example.request.category.CategoryCreateRequest;
import org.example.request.category.CategoryUpdateRequest;

public interface CategoryMapper {
    CategoryEntity mapCreateRequestToEntity(CategoryCreateRequest categoryCreateRequest);

    CategoryUpdateRequest mapEntityToUpdateRequest(CategoryEntity category);

    CategoryEntity mapUpdateRequestToEntity(CategoryEntity category, CategoryUpdateRequest categoryUpdateRequest);
}
