package org.example.repository.impl;

import org.example.entity.RoleEntity;
import org.example.repository.RoleRepository;
import org.hibernate.SessionFactory;
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
        return null;
    }

    @Override
    public RoleEntity getById(Long id) {
        return null;
    }

    @Override
    public void save(RoleEntity entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
