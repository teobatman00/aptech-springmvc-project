package org.example.controller;

import org.example.entity.CategoryEntity;
import org.example.enums.error.CategoryError;
import org.example.mapper.CategoryMapper;
import org.example.request.category.CategoryCreateRequest;
import org.example.request.category.CategoryUpdateRequest;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    public String saveCategory(@Valid @ModelAttribute("category") CategoryCreateRequest categoryCreateRequest,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "category/create";
        }

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
        CategoryUpdateRequest categoryUpdate = categoryMapper.mapEntityToUpdateRequest(category);
        model.addAttribute("categoryUpdate", categoryUpdate);
        model.addAttribute("id", category.getId());
        return "category/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("categoryUpdate") CategoryUpdateRequest categoryUpdateRequest,
                         Model model,
                         @PathVariable("id") long id) {
        CategoryEntity category = categoryService.getById(id);
        if (category == null) {
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        category = categoryMapper.mapUpdateRequestToEntity(category ,categoryUpdateRequest);
        categoryService.saveCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") long id, Model model) {
        CategoryEntity category = categoryService.getById(id);
        if (category == null) {
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        categoryService.deleteCategoryById(id);
        return "redirect:/category/list";
    }
}
