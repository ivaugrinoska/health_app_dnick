package com.example.health_app_dnick.service.impl;
import com.example.health_app_dnick.model.Category;
import com.example.health_app_dnick.model.exceptions.CategoryNotFoundException;
import com.example.health_app_dnick.repository.CategoryRepository;
import com.example.health_app_dnick.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(String category) {
        return this.categoryRepository.save(new Category(category));
    }

}
