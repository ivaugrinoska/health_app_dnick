package com.example.health_app_dnick.service;
import com.example.health_app_dnick.model.Category;

import java.util.List;

public interface CategoryService {
    Category findCategoryById(Long id);
    List<Category> findAll();

    List<Category> listCategories();
    Category addCategory(String category);
}
