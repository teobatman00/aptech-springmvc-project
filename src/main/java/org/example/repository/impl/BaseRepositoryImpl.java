package org.example.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepositoryImpl {
    protected final Session currentSession;
    @Autowired
    public BaseRepositoryImpl(SessionFactory sessionFactory) {
        currentSession = sessionFactory.getCurrentSession();
    }
}
