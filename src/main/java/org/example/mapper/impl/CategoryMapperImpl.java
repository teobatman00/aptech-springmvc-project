package org.example.mapper.impl;

import org.example.entity.CategoryEntity;
import org.example.mapper.CategoryMapper;
import org.example.request.category.CategoryCreateRequest;
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
}
