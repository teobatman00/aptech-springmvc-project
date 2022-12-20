package org.example.controller;

import org.example.entity.BookEntity;
import org.example.entity.CategoryEntity;
import org.example.request.book.BookCreateRequest;
import org.example.service.BookService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listBook(Model model) {
        List<BookEntity> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "book/index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @GetMapping("/new")
    public String addForm(Model model) {
        List<CategoryEntity> categories = categoryService.getCategory();
        BookCreateRequest book = new BookCreateRequest();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);
        return "book/create";
    }

    @PostMapping("/save")
    public String saveBook(@Validated @ModelAttribute("book") BookEntity book) {
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/load/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book/update";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }

}
