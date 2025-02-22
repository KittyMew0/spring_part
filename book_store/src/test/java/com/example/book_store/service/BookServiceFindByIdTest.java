package com.example.book_store.service;

import com.example.book_store.model.Book;
import com.example.book_store.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceFindByIdTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testFindById() {
        Book book = new Book(1L, "Book1", "Author1", "123456", 2020);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Book1", result.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }
}