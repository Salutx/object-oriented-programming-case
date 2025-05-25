package com.object_oriented_case.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.object_oriented_case.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
