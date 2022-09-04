package com.igor.bookstoremanager.service;

import com.igor.bookstoremanager.dto.BookDTO;
import com.igor.bookstoremanager.entity.Book;
import com.igor.bookstoremanager.exception.BookNotFoundException;
import com.igor.bookstoremanager.repository.BookRepository;
import com.igor.bookstoremanager.utils.BookUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {

        Book book = BookUtils.createFakeBook();

        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));

        BookDTO bookDto = bookService.findById(book.getId());

        Assertions.assertEquals(book.getName(), bookDto.getName());
        Assertions.assertEquals(book.getIsbn(), bookDto.getIsbn());
        Assertions.assertEquals(book.getPublisherName(), bookDto.getPublisherName());


    }
}
