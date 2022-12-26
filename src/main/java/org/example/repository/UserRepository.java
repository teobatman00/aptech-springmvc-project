package org.example.repository;

import org.example.entity.UserEntity;

public interface UserRepository extends BaseRepository<UserEntity, Long> {
    UserEntity getByUserNameAndPassword(String userName, String password);

    UserEntity getByUserName(String userName);
}
