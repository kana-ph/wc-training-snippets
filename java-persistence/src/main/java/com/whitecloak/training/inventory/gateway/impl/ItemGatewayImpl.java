package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
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
    public Item create(String itemName, UserEntity userEntity, CategoryEntity categoryEntity) {
        ItemEntity entity = new ItemEntity();
        entity.setOwner(userEntity);
        entity.setName(itemName);

        ItemEntity saveItemEntity = itemRepository.save(entity);

        Item item = new Item();
        item.setId( saveItemEntity.getId());
        item.setName( saveItemEntity.getName());
        item.setOwner( saveItemEntity.getOwner());
        return item;
    }
}
