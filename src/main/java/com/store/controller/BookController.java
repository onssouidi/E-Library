package com.store.controller;

import com.store.models.BookModel;
import com.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<BookModel> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

}

