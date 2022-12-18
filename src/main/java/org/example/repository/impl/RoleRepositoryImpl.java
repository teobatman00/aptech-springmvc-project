package org.example.repository.impl;

import org.example.entity.RoleEntity;
import org.example.repository.RoleRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl implements RoleRepository {

    @Autowired
    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<RoleEntity> getList() {
        Query<RoleEntity> query = currentSession.createQuery("from RoleEntity order by id desc", RoleEntity.class);
        return query.getResultList();
    }

    @Override
    public RoleEntity getById(Long id) {
        return currentSession.get(RoleEntity.class, id);
    }

    @Override
    public void save(RoleEntity entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
