package org.example.controller;

import org.example.entity.BookEntity;
import org.example.entity.CategoryEntity;
import org.example.enums.error.BookError;
import org.example.mapper.BookMapper;
import org.example.request.book.BookCreateRequest;
import org.example.request.book.BookUpdateRequest;
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
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.bookMapper = bookMapper;
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
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
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
    public String saveBook(@Validated @ModelAttribute("book") BookCreateRequest bookCreateRequest) {
        BookEntity bookEntity = bookMapper.mapCreateRequestToEntity(bookCreateRequest);
        bookService.saveBook(bookEntity);
        return "redirect:/book/list";
    }

    @GetMapping("/load/{id}")
    public String updateForm(@PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
        List<CategoryEntity> categories = categoryService.getCategory();
        BookUpdateRequest bookUpdateRequest = bookMapper.mapEntityToUpdateRequest(book);
        model.addAttribute("bookUpdate", bookUpdateRequest);
        model.addAttribute("categories", categories);
        return "book/update";
    }

    @PostMapping("/load/{id}")
    public String updateBook(@Validated @ModelAttribute("bookUpdate") BookUpdateRequest bookUpdateRequest, @PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
        book = bookMapper.mapUpdateRequestToEntity(bookUpdateRequest, book);
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }

}
