package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

public interface ItemService {

    ItemResource create(ItemForm form);
    ItemEntity getItem(Long id);
}
