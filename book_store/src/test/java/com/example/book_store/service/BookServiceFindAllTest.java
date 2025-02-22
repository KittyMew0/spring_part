package com.example.book_store.service;

import com.example.book_store.model.Book;
import com.example.book_store.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceFindAllTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testFindAll() {
        List<Book> books = List.of(
                new Book(1L, "Book1", "Author1", "123456", 2020),
                new Book(2L, "Book2", "Author2", "654321", 2021)
        );

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAll();
        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findAll();
    }
}