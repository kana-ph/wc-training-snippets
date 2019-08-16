package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;


    public CategoryGatewayImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name){
        CategoryEntity entity=new CategoryEntity();
        entity.setName(name);
        CategoryEntity savedEntity=categoryRepository.save(entity);
        Category category=new Category();
        category.setId(savedEntity.getId());
        category.setName(savedEntity.getName());
        return category;
    }
}
