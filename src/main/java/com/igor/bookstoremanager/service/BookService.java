package com.igor.bookstoremanager.service;

import com.igor.bookstoremanager.dto.MessageResponseDTO;
import com.igor.bookstoremanager.entity.Book;
import com.igor.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public MessageResponseDTO create(Book book){
        Book bookSaved = bookRepository.save(book);

        return MessageResponseDTO.builder()
                .message("Book created with ID: " + bookSaved.getId())
                .build();
    }
}
