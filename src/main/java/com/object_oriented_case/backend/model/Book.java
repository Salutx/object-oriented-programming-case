package com.object_oriented_case.backend.model;

import java.sql.Timestamp;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;
    private String publisher;
    private String publishedIn;

    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "userId")
    private User createdBy;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(name = "book_categories", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories;

}
