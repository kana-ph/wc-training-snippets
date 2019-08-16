package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryForm form);
}
