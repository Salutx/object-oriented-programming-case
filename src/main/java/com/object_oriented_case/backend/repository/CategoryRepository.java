package com.object_oriented_case.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.object_oriented_case.backend.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
