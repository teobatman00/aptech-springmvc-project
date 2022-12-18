package org.example.controller;

import org.example.entity.BookEntity;
import org.example.entity.CategoryEntity;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listCategory(Model model) {
        List<CategoryEntity> categories = categoryService.getCategory();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        CategoryEntity category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "category/detail";
    }

    @GetMapping("/new")
    public String addForm(Model model) {
        CategoryEntity category = new CategoryEntity();
        model.addAttribute("category", category);
        return "category/create";
    }

    @PostMapping("/save")
    public String saveCategory(@Validated @ModelAttribute("category") CategoryEntity category) {
        categoryService.saveCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/load/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        CategoryEntity category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category/list";
    }
}
