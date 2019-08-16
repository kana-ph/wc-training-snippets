package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryGatewayImpl(CategoryRepository categoryRepository){ this.categoryRepository = categoryRepository; }

    @Override
    public Category createCategory(CategoryForm categoryForm){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(categoryForm.getName());

        CategoryEntity savedEntity = categoryRepository.save(entity);

        Category category = new Category();
        category.setId(savedEntity.getId());
        category.setName(savedEntity.getName());
        category.setItems(savedEntity.getItems());

        return category;
    }
}
