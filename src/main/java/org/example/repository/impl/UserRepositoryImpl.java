package org.example.repository.impl;

import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Query<UserEntity> query = currentSession.createQuery("from UserEntity order by id desc", UserEntity.class);
        return query.getResultList();
    }

    @Override
    public UserEntity getById(Long id) {
        return currentSession.get(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity entity) {
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        UserEntity userEntity = currentSession.get(UserEntity.class, id);
        currentSession.delete(userEntity);
    }
}
