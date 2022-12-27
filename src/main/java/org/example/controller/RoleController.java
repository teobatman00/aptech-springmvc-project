package org.example.controller;

import org.example.entity.RoleEntity;
import org.example.enums.error.RoleError;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String listRole(Model model) {
        List<RoleEntity> roles = roleService.getRoles();
        model.addAttribute("roles", roles);
        return "role/index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        RoleEntity role = roleService.getById(id);
        if (role == null) {
            model.addAttribute("error", RoleError.NOT_FOUND.getMessage());
            return "error/404";
        }
        model.addAttribute("role", role);
        return "role/detail";
    }

}
