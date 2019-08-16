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
    public Item createItem(String itemName, UserEntity userEntity, CategoryEntity categoryEntity) {
        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setItemName(itemName);
        itemEntity.setOwner(userEntity);
        itemEntity.setCategory(categoryEntity);

        ItemEntity savedItemEntity = itemRepository.save(itemEntity);

        Item item = new Item();

        item.setId(savedItemEntity.getId());
        item.setItemName(savedItemEntity.getItemName());
        item.setOwner(savedItemEntity.getOwner());
        item.setCategory(savedItemEntity.getCategory());

        return item;
    }
}
