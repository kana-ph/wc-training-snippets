package com.whitecloak.training.inventory.gateway.impl;

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
    public CategoryGatewayImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name) {
        CategoryEntity newCategory = new CategoryEntity();
        newCategory.setName(name);

        CategoryEntity saveCategory = categoryRepository.save(newCategory);

        Category category = new Category();
        category.setId(saveCategory.getId());
        category.setName(saveCategory.getName());
//        category.setItems(saveCategory.getItems());
        return category;
    }
}
