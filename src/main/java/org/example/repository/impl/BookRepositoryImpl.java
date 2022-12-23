package org.example.repository.impl;

import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final Session currentSession;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        currentSession = sessionFactory.getCurrentSession();
    }

    @Override
    public List<BookEntity> getList() {
        Query<BookEntity> query = currentSession.createQuery("from BookEntity order by id desc", BookEntity.class);
        return query.getResultList();
    }

    @Override
    public BookEntity getById(Long id) {
        return currentSession.get(BookEntity.class, id);
    }

    @Override
    public void save(BookEntity entity) {
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        BookEntity bookEntity = currentSession.get(BookEntity.class, id);
        currentSession.remove(bookEntity);
    }
}
