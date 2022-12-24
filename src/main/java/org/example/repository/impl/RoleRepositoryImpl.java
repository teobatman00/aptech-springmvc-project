package org.example.repository.impl;

import org.example.entity.RoleEntity;
import org.example.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {


    private SessionFactory sessionFactory;

    @Autowired
    public RoleRepositoryImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<RoleEntity> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<RoleEntity> query = currentSession.createQuery("from RoleEntity order by id desc", RoleEntity.class);
        return query.getResultList();
    }

    @Override
    public RoleEntity getById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(RoleEntity.class, id);
    }

    @Override
    public void save(RoleEntity entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
