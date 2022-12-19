package org.example.service.impl;

import org.example.enums.UserRole;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.request.LoginRequest;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public String checkLoginUser(LoginRequest request) {
        return null;
    }

    @Override
    public UserRole checkUserRole(LoginRequest request) {
        return null;
    }
}
