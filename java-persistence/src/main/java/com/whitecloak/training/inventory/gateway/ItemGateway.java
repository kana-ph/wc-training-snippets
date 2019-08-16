package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

public interface ItemGateway {

    Item create(String name);

    ItemEntity findBy(Long id);
}
