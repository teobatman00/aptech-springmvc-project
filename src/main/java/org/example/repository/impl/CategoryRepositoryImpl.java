package org.example.repository.impl;

import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {


    private SessionFactory sessionFactory;

    @Autowired
    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<CategoryEntity> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryEntity> query = currentSession.createQuery("from CategoryEntity order by id desc", CategoryEntity.class);
        return query.getResultList();
    }

    @Override
    public CategoryEntity getById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(CategoryEntity.class, id);
    }

    @Override
    public void save(CategoryEntity entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        CategoryEntity categoryEntity = currentSession.get(CategoryEntity.class, id);
        currentSession.delete(categoryEntity);
    }

    @Override
    public boolean existedByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryEntity> query = currentSession.createQuery("from CategoryEntity where name = :name", CategoryEntity.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.getResultList().size() > 0;
    }
}
