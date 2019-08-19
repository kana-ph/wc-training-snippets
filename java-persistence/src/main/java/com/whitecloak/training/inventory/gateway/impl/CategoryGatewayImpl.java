package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryGatewayImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(name);
        CategoryEntity savedEntity = categoryRepository.save(categoryEntity);

        Category category = new Category();
        category.setId(savedEntity.getId());
        category.setName(savedEntity.getName());

        return category;
    }

}
