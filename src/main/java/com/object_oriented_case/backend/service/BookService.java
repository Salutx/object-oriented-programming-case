package com.object_oriented_case.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.object_oriented_case.backend.model.BookModel;
import com.object_oriented_case.backend.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookModel getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }

    // public BookModel updateBook(Long id, BookModel book) {

    // }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
