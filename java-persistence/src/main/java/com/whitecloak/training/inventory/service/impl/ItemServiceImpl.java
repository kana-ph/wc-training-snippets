package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Item item = itemGateway.create(form);

        ItemResource itemResource = new ItemResource();
        itemResource.setId(item.getId());
        itemResource.setName(item.getName());
        itemResource.setOwnerId(item.getOwnerId().getId());
        itemResource.setCategoryId(item.getCategoryId().getId());
        return itemResource;
    }

    @Override
    public ItemResource getItem(Long id) {
        Item item = itemGateway.getItem(id);

        if(item.getStatus().equals("Active")){
            ItemResource itemResource = new ItemResource();
            itemResource.setId(item.getId());
            itemResource.setName(item.getName());
            itemResource.setOwnerId(item.getOwnerId().getId());
            itemResource.setCategoryId(item.getCategoryId().getId());
            return itemResource;
        }
        else{
            return null;
        }

    }

    @Override
    public ItemResource deleteItem(Long id) {
        itemGateway.deleteItem(id);
        return null;
    }

    private ItemResource mapModelToResource(Item item){
        ItemResource itemResource = new ItemResource();
        itemResource.setId(item.getId());
        itemResource.setName(item.getName());
        itemResource.setOwnerId(item.getOwnerId().getId());
        itemResource.setCategoryId(item.getCategoryId().getId());
        return itemResource;
    }

    @Override
    public Page<ItemResource> getItems(Pageable pageable) {
        return itemGateway.getItems(pageable).map(this::mapModelToResource);
    }

    @Override
    public Page<ItemResource> getItems(String category, Pageable pageable) {
        return itemGateway.getItems(category, pageable).map(this::mapModelToResource);
    }
}
