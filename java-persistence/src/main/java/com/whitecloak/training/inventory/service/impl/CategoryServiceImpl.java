package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryGateway categoryGateway;

    @Autowired
    CategoryServiceImpl(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public CategoryResource createCategory(CategoryForm categoryForm){
        Category category = categoryGateway.createCategory(categoryForm);

        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setId(category.getId());
        categoryResource.setName(category.getName());
        return categoryResource;
    }
}
