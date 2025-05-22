package com.object_oriented_case.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.object_oriented_case.backend.model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long> {

}
