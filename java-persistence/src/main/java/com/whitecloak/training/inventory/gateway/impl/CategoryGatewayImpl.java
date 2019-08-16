package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class CategoryGatewayImpl implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryGatewayImpl(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository; };

    @Override
    public Category create(String categoryName, Set<ItemEntity> itemEntity){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(categoryName);
        entity.setItems(itemEntity);

        CategoryEntity saveCategoryEntity = categoryRepository.save(entity);

        Category category = new Category();
        category.setId(saveCategoryEntity.getId());
        category.setName(saveCategoryEntity.getName());
        category.setItems(saveCategoryEntity.getItems());
        return category;
    }


}
