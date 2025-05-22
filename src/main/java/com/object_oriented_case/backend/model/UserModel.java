package com.object_oriented_case.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserModel {
    @Id
    private Long userId;
    private String name;
    private String username;
    private String email;
    private String password;
    private String created_at;
}
