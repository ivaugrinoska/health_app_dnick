package com.example.health_app_dnick.web;
import com.example.health_app_dnick.service.impl.CategoryServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String allCategories(Model model) {
        model.addAttribute("categories",this.categoryService.findAll());
        return "allBooks";
    }

    @GetMapping("/addCategory")
    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    public String addNewCategory(){

        return "addCategory";
    }

    @PostMapping("/add-category")
    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    public String addCategory(@RequestParam(required = false) Long id, HttpServletRequest request){
        String categoryName = request.getParameter("category");

        this.categoryService.addCategory(categoryName);

        return "redirect:/categories";
    }

}
