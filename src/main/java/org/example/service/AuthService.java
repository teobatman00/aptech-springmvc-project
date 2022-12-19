package org.example.service;

import org.example.enums.UserRole;
import org.example.request.LoginRequest;

public interface AuthService {
    String checkLoginUser(LoginRequest request);

    UserRole checkUserRole(LoginRequest request);
}
