package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

import java.util.Set;

public interface CategoryService {
    CategoryResource create(String name, Set<ItemEntity> items);
}
