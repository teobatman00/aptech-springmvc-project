package org.example.controller;

import org.example.entity.UserEntity;
import org.example.request.auth.LoginRequest;
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

    @GetMapping("/loginPage")
    public String login(Model model) {
        model.addAttribute("userLogin", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userLogin") LoginRequest request, Model model) {
        UserEntity userEntity = authService.getUserLogin(request);
        if (userEntity == null) {
            model.addAttribute("errorMessage", "Username or password not match");
            return "auth/login";
        }
//        UserRole userRole = authService.checkUserRole(request);
        model.addAttribute("users", userEntity);
        return "redirect:/book/list";
    }
}
