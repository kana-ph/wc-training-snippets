package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public interface ItemGateway {
    Item create(String itemName, UserEntity userEntity, CategoryEntity categoryEntity);
}
