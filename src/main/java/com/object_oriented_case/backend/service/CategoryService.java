package com.object_oriented_case.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.object_oriented_case.backend.dto.CategoryCreateRequest;
import com.object_oriented_case.backend.dto.CategoryUpdateRequest;
import com.object_oriented_case.backend.model.Category;
import com.object_oriented_case.backend.model.User;
import com.object_oriented_case.backend.repository.CategoryRepository;

@Service
public class CategoryService {

    private final UserService userService;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(CategoryCreateRequest category) {
        Category newCategory = new Category();
        User createdBy = userService.getUserById(category.getCreatedById());

        System.out.println("createdBy" + createdBy);

        newCategory.setName(category.getName());
        newCategory.setCreatedBy(createdBy);

        return categoryRepository.save(newCategory);
    }

    public Category updateCategory(Long id, CategoryUpdateRequest categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDetails.getName());
                    return categoryRepository.save(category);
                })
                .orElse(null);
    }

    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
