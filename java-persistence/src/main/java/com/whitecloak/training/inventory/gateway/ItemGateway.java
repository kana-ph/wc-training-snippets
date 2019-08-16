package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.model.Item;

public interface ItemGateway {

    Item createItem(ItemForm itemForm);
}
