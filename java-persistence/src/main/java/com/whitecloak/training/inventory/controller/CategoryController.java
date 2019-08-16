package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category")
    public CategoryResource createCategory(@RequestBody CategoryForm categoryForm){
        return categoryService.createCategory(categoryForm);
    }

    @GetMapping("/category/{id}")
    public CategoryResource fetchCategoryById(@PathVariable Long id){
        return new CategoryResource(categoryService.fetchCategoryById(id).getId(), categoryService.fetchCategoryById(id).getCategoryName());
    }

}
