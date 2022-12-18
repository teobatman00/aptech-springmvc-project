package org.example.service.impl;

import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.getList();
    }

    @Override
    public UserEntity getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteCategoryById(long id) {
        userRepository.deleteById(id);
    }
}
