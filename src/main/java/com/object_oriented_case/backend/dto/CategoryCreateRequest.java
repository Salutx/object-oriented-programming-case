package com.object_oriented_case.backend.dto;

public class CategoryCreateRequest {
    private String name;
    private Long createdById;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

}
