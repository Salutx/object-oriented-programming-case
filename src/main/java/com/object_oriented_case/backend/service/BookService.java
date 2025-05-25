package com.object_oriented_case.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.object_oriented_case.backend.model.Book;
import com.object_oriented_case.backend.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(bookDetails.getName());
                    book.setPublisher(bookDetails.getPublisher());
                    book.setPublishedIn(bookDetails.getPublishedIn());
                    book.setCategories(bookDetails.getCategories());
                    return bookRepository.save(book);
                })
                .orElse(null);
    }

    public boolean deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
