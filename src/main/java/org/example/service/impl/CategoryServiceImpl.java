package org.example.service.impl;

import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getCategory() {
        return categoryRepository.getList();
    }

    @Override
    public CategoryEntity getById(long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void saveCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
