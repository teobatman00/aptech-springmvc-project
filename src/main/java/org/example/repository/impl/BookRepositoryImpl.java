package org.example.repository.impl;

import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl extends BaseRepositoryImpl implements BookRepository {

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<BookEntity> getList() {
        return null;
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
        currentSession.delete(bookEntity);
    }
}
