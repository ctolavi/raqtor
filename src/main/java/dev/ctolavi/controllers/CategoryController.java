package dev.ctolavi.controllers;

import dev.ctolavi.entities.Category;
import dev.ctolavi.repositories.CategoryRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.persist(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll().list();
    }
}
