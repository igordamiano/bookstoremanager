package com.igor.bookstoremanager.controller;

import com.igor.bookstoremanager.dto.BookDTO;
import com.igor.bookstoremanager.dto.MessageResponseDTO;
import com.igor.bookstoremanager.entity.Book;
import com.igor.bookstoremanager.repository.BookRepository;
import com.igor.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

}
