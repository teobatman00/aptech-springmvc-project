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


    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEntity> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UserEntity> query = currentSession.createQuery("from UserEntity order by id desc", UserEntity.class);
        return query.getResultList();
    }

    @Override
    public UserEntity getById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(entity);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        UserEntity userEntity = currentSession.get(UserEntity.class, id);
        currentSession.delete(userEntity);
    }

    @Override
    public UserEntity getByUserNameAndPassword(String userName, String password) {
        Session currentSession = sessionFactory.getCurrentSession();
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
