package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.model.Category;

public interface CategoryGateway {
    Category create(CategoryForm form);
}