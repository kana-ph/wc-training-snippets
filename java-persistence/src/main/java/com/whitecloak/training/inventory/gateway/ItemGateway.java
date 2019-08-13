package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Item;

public interface ItemGateway {

    Item create(String name);
}
