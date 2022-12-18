package org.example.repository.impl;

import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<UserEntity> getList() {
        return null;
    }

    @Override
    public UserEntity getById(Long id) {
        return null;
    }

    @Override
    public void save(UserEntity entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
