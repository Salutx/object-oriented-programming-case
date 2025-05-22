package com.object_oriented_case.backend.model;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class CategoryModel {
    @Id
    private Long categoryId;
    private String name;
    private String created_at;

    @ManyToMany(mappedBy = "category")
    private HashSet<BookModel> books;

    @Id
    private Long created_by;
}
