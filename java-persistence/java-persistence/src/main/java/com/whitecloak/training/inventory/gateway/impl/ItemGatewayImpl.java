package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;

    @Autowired
    ItemGatewayImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(String name) {
        ItemEntity entity = new ItemEntity();
        entity.setOwnerId(99L);
        entity.setName(name);

        ItemEntity savedEntity = itemRepository.save(entity);

        Item item = new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        item.setOwnerId(savedEntity.getOwnerId());
        return item;
    }
}
