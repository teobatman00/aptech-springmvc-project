package org.example.service;

import org.example.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    UserEntity getById(long id);

    void saveUser(UserEntity user);

    void deleteCategoryById(long id);
}
