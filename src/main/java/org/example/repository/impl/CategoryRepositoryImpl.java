package org.example.repository.impl;

import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Query<CategoryEntity> query = currentSession.createQuery("from CategoryEntity order by id desc", CategoryEntity.class);
        return query.getResultList();
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

    @Override
    public boolean existedByName(String name) {
        Query<CategoryEntity> query = currentSession.createQuery("from CategoryEntity where name = :name", CategoryEntity.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.getResultList().size() > 0;
    }
}
