package org.example.controller;

import org.example.entity.CategoryEntity;
import org.example.enums.error.CategoryError;
import org.example.mapper.CategoryMapper;
import org.example.request.category.CategoryCreateRequest;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
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
        if (category == null) {
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        model.addAttribute("category", category);
        return "category/detail";
    }

    @GetMapping("/new")
    public String addForm(Model model) {
        CategoryCreateRequest categoryCreateRequest = new CategoryCreateRequest();
        model.addAttribute("category", categoryCreateRequest);
        return "category/create";
    }

    @PostMapping("/save")
    public String saveCategory(@Validated @ModelAttribute("category") CategoryCreateRequest categoryCreateRequest, Model model) {
        if (categoryService.existedCategoryByName(categoryCreateRequest.getName())) {
            model.addAttribute("errorMessage", CategoryError.EXISTED_BY_NAME.getMessage());
            return "error/400";
        }
        CategoryEntity category = categoryMapper.mapCreateRequestToEntity(categoryCreateRequest);
        categoryService.saveCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/load/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        CategoryEntity category = categoryService.getById(id);
        if (category == null) {
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") long id, Model model, HttpServletResponse response) {
        CategoryEntity category = categoryService.getById(id);
        if (category == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        categoryService.deleteCategoryById(id);
        response.setStatus(HttpServletResponse.SC_OK);
        return "redirect:/category/list";
    }
}
