package com.object_oriented_case.backend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.object_oriented_case.backend.dto.BookCreateRequest;
import com.object_oriented_case.backend.model.Book;
import com.object_oriented_case.backend.model.Category;
import com.object_oriented_case.backend.model.User;
import com.object_oriented_case.backend.repository.BookRepository;

@Service
public class BookService {

    private final UserService userService;
    private final CategoryService categoryService;

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, UserService userService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(BookCreateRequest book) {
        Book newBook = new Book();
        User createdBy = userService.getUserById(book.getCreatedById());

        newBook.setName(book.getName());
        newBook.setPublisher(book.getPublisher());
        newBook.setPublishedIn(book.getPublishedIn());
        newBook.setAuthor(book.getAuthor());
        newBook.setCreatedBy(createdBy);

        Set<Category> categories = book.getCategoryIds().stream()
                .map(categoryService::getCategoryById)
                .collect(Collectors.toSet());

        newBook.setCategories(categories);

        return bookRepository.save(newBook);
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
