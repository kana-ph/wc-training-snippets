package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;

public interface CategoryService {
    CategoryResource create(CategoryForm form);
}
