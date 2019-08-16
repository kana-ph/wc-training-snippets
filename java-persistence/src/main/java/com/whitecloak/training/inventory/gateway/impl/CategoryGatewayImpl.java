package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryGatewayImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(name);

        CategoryEntity savedCategory = categoryRepository.save(entity);

        Category category = new Category();
        category.setId(savedCategory.getId());
        category.setItem(savedCategory.getItem());
        category.setName(savedCategory.getName());
        return category;
    }
}
