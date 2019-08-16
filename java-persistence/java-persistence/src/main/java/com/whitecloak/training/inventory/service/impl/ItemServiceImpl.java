package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ItemServiceImpl implements ItemService {

    private final ItemGateway itemGateway;

    @Autowired
    ItemServiceImpl(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    @Override
    public ItemResource create(ItemForm form) {
        Item item = itemGateway.create(form.getName());

        ItemResource itemResource = new ItemResource();
        itemResource.setId(item.getId());
        itemResource.setName(item.getName());
        itemResource.setOwnerId(item.getOwnerId());
        return itemResource;
    }
}
