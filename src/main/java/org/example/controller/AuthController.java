package org.example.controller;

import org.example.enums.UserRole;
import org.example.request.LoginRequest;
import org.example.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userLogin", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userLogin") LoginRequest request, Model model) {
        String errorMessage = authService.checkLoginUser(request);
        UserRole userRole = authService.checkUserRole(request);
        return "redirect:/book/list";
    }
}
