package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.gateway.impl.CategoryGatewayImpl;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryGateway categoryGateway;

    @Autowired
    public CategoryServiceImpl(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public CategoryResource create(CategoryForm form) {
        Category category = categoryGateway.create(form);

        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setId(category.getId());
        categoryResource.setName(category.getName());
        return categoryResource;
    }
}
