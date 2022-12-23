package org.example.service.impl;

import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<UserEntity> getUsers() {
        return userRepository.getList();
    }

    @Override
    @Transactional
    public UserEntity getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteCategoryById(long id) {
        userRepository.deleteById(id);
    }
}
