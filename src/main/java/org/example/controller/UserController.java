package org.example.controller;

import org.example.entity.UserEntity;
import org.example.enums.error.UserError;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUser(Model model) {
        List<UserEntity> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        UserEntity user = userService.getById(id);
        if (user == null) {
            model.addAttribute("errorMessage", UserError.NOT_FOUND.getMessage());
            return "error/404";
        }
        model.addAttribute("user", user);
        return "user/detail";
    }

    @GetMapping("/new")
    public String addForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "user/create";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") UserEntity user) {
        userService.saveUser(user);
        return "redirect:/category/list";
    }

    @GetMapping("/load/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        UserEntity user = userService.getById(id);
        if (user == null) {
            model.addAttribute("errorMessage", UserError.NOT_FOUND.getMessage());
            return "error/404";
        }
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id, Model model) {
        UserEntity user = userService.getById(id);
        if (user == null) {
            model.addAttribute("errorMessage", UserError.NOT_FOUND.getMessage());
            return "error/404";
        }
        userService.deleteCategoryById(id);
        return "redirect:/user/list";
    }
}
