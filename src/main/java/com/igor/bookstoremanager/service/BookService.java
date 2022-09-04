package com.igor.bookstoremanager.service;

import com.igor.bookstoremanager.dto.BookDTO;
import com.igor.bookstoremanager.dto.MessageResponseDTO;
import com.igor.bookstoremanager.entity.Book;
import com.igor.bookstoremanager.mapper.BookMapper;
import com.igor.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);

        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDTO(optionalBook.get());

    }
}
