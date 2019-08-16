package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

import java.util.Set;

public interface CategoryGateway {
    Category create(String categoryName, Set<ItemEntity> itemEntity);
}
