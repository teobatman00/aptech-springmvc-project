package org.example.controller;

import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
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
        BookEntity book = new BookEntity();
        model.addAttribute("book", book);
        return "book/create";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") BookEntity book) {
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
