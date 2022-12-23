package org.example.mapper.impl;

import org.example.entity.CategoryEntity;
import org.example.mapper.CategoryMapper;
import org.example.request.category.CategoryCreateRequest;
import org.example.request.category.CategoryUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity mapCreateRequestToEntity(CategoryCreateRequest categoryCreateRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setName(categoryCreateRequest.getName());
        category.setDescription(categoryCreateRequest.getDescription());
        return category;
    }

    @Override
    public CategoryUpdateRequest mapEntityToUpdateRequest(CategoryEntity category) {
        CategoryUpdateRequest categoryUpdateRequest = new CategoryUpdateRequest();
        categoryUpdateRequest.setName(category.getName());
        categoryUpdateRequest.setDescription(category.getDescription());
        return categoryUpdateRequest;
    }

    @Override
    public CategoryEntity mapUpdateRequestToEntity(CategoryEntity category, CategoryUpdateRequest categoryUpdateRequest) {
        category.setName(categoryUpdateRequest.getName());
        category.setDescription(categoryUpdateRequest.getDescription());
        return category;
    }
}
