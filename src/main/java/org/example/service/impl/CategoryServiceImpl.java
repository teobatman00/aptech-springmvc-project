package org.example.service.impl;

import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public List<CategoryEntity> getCategory() {
        return categoryRepository.getList();
    }

    @Override
    @Transactional
    public CategoryEntity getById(long id) {
        return categoryRepository.getById(id);
    }

    @Override
    @Transactional
    public void saveCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean existedCategoryByName(String name) {
        return categoryRepository.existedByName(name);
    }
}
