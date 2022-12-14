package org.example.controller;

import org.example.entity.BookEntity;
import org.example.entity.CategoryEntity;
import org.example.enums.error.BookError;
import org.example.enums.error.CategoryError;
import org.example.mapper.BookMapper;
import org.example.request.book.BookCreateRequest;
import org.example.request.book.BookUpdateRequest;
import org.example.response.BookGetDetailResponse;
import org.example.response.BookGetListResponse;
import org.example.service.BookService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
        List<BookGetListResponse> bookResponse = books.stream().map(bookMapper::mapEntityToGetListResponse).collect(Collectors.toList());
        model.addAttribute("books", bookResponse);
        return "book/index";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        BookEntity book = bookService.getById(id);
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
        BookGetDetailResponse detailResponse = bookMapper.mapEntityToDetailResponse(book);
        model.addAttribute("book", detailResponse);
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
    public String saveBook(@Valid @ModelAttribute("book") BookCreateRequest bookCreateRequest, Model model) {
        CategoryEntity categoryEntity = categoryService.getById(bookCreateRequest.getCategoryId());
        if (categoryEntity == null) {
            model.addAttribute("errorMessage", CategoryError.NOT_FOUND.getMessage());
            return "error/404";
        }
        BookEntity bookEntity = bookMapper.mapCreateRequestToEntity(bookCreateRequest);
        bookEntity.setCategory(categoryEntity);
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
        model.addAttribute("id", book.getId());
        return "book/update";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@Valid @ModelAttribute("bookUpdate") BookUpdateRequest bookUpdateRequest, @PathVariable("id") long id, Model model) throws IOException {
        BookEntity book = bookService.getById(id);
        if (book == null) {
            model.addAttribute("errorMessage", BookError.NOT_FOUND.getMessage());
            return "error/404";
        }
        book = bookMapper.mapUpdateRequestToEntity(bookUpdateRequest, book);
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }

}
