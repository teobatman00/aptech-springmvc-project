package org.example.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public abstract class BaseRepositoryImpl {
    protected Session currentSession;

    protected BaseRepositoryImpl(SessionFactory sessionFactory) {
        try {
            currentSession = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            currentSession = sessionFactory.openSession();
        }
    }
}
