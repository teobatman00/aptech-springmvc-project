package org.example.repository.impl;

import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl extends BaseRepositoryImpl implements CategoryRepository {

    @Autowired
    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<CategoryEntity> getList() {
        return null;
    }

    @Override
    public CategoryEntity getById(Long id) {
        return currentSession.get(CategoryEntity.class, id);
    }

    @Override
    public void save(CategoryEntity entity) {
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        CategoryEntity categoryEntity = currentSession.get(CategoryEntity.class, id);
        currentSession.delete(categoryEntity);
    }
}
