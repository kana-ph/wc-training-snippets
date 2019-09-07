package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;

public interface CategoryService {

    CategoryResource createCategory(CategoryForm categoryForm);

    CategoryEntity fetchCategoryById(Long id);
}
