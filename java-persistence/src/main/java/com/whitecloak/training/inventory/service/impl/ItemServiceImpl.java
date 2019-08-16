package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.service.ItemService;
import jdk.javadoc.internal.doclets.toolkit.taglets.PropertyGetterTaglet;
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
        itemResource.setOwner(item.getOwner());
        itemResource.setCategory(item.getCategory());
        return itemResource;
    }

    @Override
    public ItemResource getUser(Long id){
        Item item=itemGateway.getUser(id);
            ItemResource itemResource = new ItemResource();
            itemResource.setId(item.getId());
            itemResource.setName(item.getName());
            itemResource.setOwner(item.getOwner());
            itemResource.setCategory(item.getCategory());
            return itemResource;
    }

    @Override
    public void delete(Long id) {
        itemGateway.delete(id);
    }

    @Override
    public Page<ItemResource> findAll(Pageable pageable) {

        return itemGateway.findAll(pageable).map(Item->{
            ItemResource itemResource=new ItemResource();
            itemResource.setId(Item.getId());
            itemResource.setName(Item.getName());
            itemResource.setOwner(Item.getOwner());
            itemResource.setCategory(Item.getCategory());
        return itemResource;
        });
    }

    @Override
    public Page<ItemResource> findAllByCategory_Name(String category, Pageable pageable) {
        return itemGateway.findAllByCategory_Name(category, pageable).map(Item->{
            ItemResource itemResource=new ItemResource();

                itemResource.setId(Item.getId());
                itemResource.setName(Item.getName());
                itemResource.setOwner(Item.getOwner());
                itemResource.setCategory(Item.getCategory());
                return itemResource;


        });
    }
}
