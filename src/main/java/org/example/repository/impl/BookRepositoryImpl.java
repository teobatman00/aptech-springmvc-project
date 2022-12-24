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
    private SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BookEntity> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<BookEntity> query = currentSession.createQuery("from BookEntity order by id desc", BookEntity.class);
        return query.getResultList();
    }

    @Override
    public BookEntity getById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(BookEntity.class, id);
    }

    @Override
    public void save(BookEntity entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        BookEntity bookEntity = currentSession.get(BookEntity.class, id);
        currentSession.remove(bookEntity);
    }
}
