package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResponse;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryGateway categoryGateway;

    @Autowired
    CategoryServiceImpl(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public CategoryResponse createCategory(CategoryForm form){
        Category category = categoryGateway.createCategory(form.getName());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        return categoryResponse;
    }
}
