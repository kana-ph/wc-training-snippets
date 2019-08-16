package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class CategoryServiceImpl implements CategoryService {

    private final CategoryGateway categoryGateway;

    @Autowired
    CategoryServiceImpl(CategoryGateway categoryGateway){ this.categoryGateway = categoryGateway; };

    @Override
    public CategoryResource create(String name, Set<ItemEntity> items){
        Category category = categoryGateway.create(name, items);

        CategoryResource categoryResource = new CategoryResource();
        categoryResource.setId(category.getId());
        categoryResource.setName(category.getName());
        categoryResource.setItems(category.getItems());
        return categoryResource;
    }

}
