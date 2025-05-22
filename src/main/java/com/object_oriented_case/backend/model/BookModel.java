package com.object_oriented_case.backend.model;

import java.util.HashSet;
import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class BookModel {
    @Id
    private Long bookId;
    private String name;
    private String publisher;
    private String published_in;
    private String created_at;

    @ManyToMany
    @JoinTable(name = "book_categories", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private HashSet<Category> categories;

    @Id
    private Long created_by;
}
