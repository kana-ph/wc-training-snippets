package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    ItemGatewayImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Item createItem(ItemForm itemForm) {
        ItemEntity entity = new ItemEntity();
        //entity.setOwnerId(99L);
        entity.setName(itemForm.getName());
        entity.setCategory(categoryRepository.findById(itemForm.getCategoryId()));
        entity.setOwner(userRepository.findById(itemForm.getOwnerId()));

        ItemEntity savedEntity = itemRepository.save(entity);

        Item item = new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        //item.setOwnerId(savedEntity.getOwnerId());
        //item.setCategory(categoryRepository.findById(itemForm.getCategoryId(
        return item;
    }
}
