package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    @Autowired

    public CategoryGatewayImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String categoryName/*, Set<Item> items*/) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryName(categoryName);
//        categoryEntity.setItems(items);

        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);

        Category category = new Category();

        category.setId(savedCategoryEntity.getId());
        category.setCategoryName(savedCategoryEntity.getCategoryName());
//        category.setItems(savedCategoryEntity.getItems());

        return category;
    }
}
