package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;

public interface CategoryGateway {
    Category create(String name);
}
