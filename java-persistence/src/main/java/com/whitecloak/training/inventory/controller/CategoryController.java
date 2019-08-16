package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("api/v1/categories")
    public CategoryResource createCategory(@RequestBody CategoryForm form){
        return categoryService.create(form);
    }

}
