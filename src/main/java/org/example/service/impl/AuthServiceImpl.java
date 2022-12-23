package org.example.service.impl;

import org.example.entity.UserEntity;
import org.example.enums.UserRole;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.request.auth.LoginRequest;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserEntity getUserLogin(LoginRequest request) {
        return userRepository.getByUserNameAndPassword(request.getUserName(), request.getPassword());
    }

    @Override
    @Transactional
    public UserRole checkUserRole(LoginRequest request) {
        return null;
    }
}
