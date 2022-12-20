package org.example.service;

import org.example.entity.UserEntity;
import org.example.enums.UserRole;
import org.example.request.auth.LoginRequest;

public interface AuthService {
    UserEntity getUserLogin(LoginRequest request);

    UserRole checkUserRole(LoginRequest request);
}
