package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;

public interface ItemService {

    ItemResource createItem(ItemForm itemForm);
}
