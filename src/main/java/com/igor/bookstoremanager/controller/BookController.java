package com.igor.bookstoremanager.controller;

import com.igor.bookstoremanager.dto.BookDTO;
import com.igor.bookstoremanager.dto.MessageResponseDTO;
import com.igor.bookstoremanager.entity.Book;
import com.igor.bookstoremanager.repository.BookRepository;
import com.igor.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id){
        return bookService.findById(id);

    }


}
