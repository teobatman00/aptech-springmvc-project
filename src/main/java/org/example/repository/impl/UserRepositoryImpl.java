package org.example.repository.impl;

import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Session currentSession;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        currentSession = sessionFactory.getCurrentSession();
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

    @Override
    public UserEntity getByUserNameAndPassword(String userName, String password) {
        Query<UserEntity> query = currentSession.createQuery(
                "from UserEntity where userName = :userName and password = :password",
                UserEntity.class);
        query.setParameter("userName", userName)
                .setParameter("password", password);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getSingleResult();
    }
}
