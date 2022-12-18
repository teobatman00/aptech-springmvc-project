package org.example.service;

import org.example.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getCategory();

    CategoryEntity getById(long id);

    void saveCategory(CategoryEntity category);

    void deleteCategoryById(long id);
}
