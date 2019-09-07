package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.stereotype.Service;

@Service
class ItemServiceImpl implements ItemService {

    private final ItemGateway itemGateway;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemGateway itemGateway, ItemRepository itemRepository) {
        this.itemGateway = itemGateway;
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemResource createItem(ItemForm itemForm, UserEntity userEntity, CategoryEntity categoryEntity) {
        Item item = itemGateway.createItem(itemForm.getItemName(), userEntity, categoryEntity);

        ItemResource itemResource = new ItemResource();

        itemResource.setId(item.getId());
        itemResource.setItemName(item.getItemName());
        itemResource.setOwner(item.getOwner());
        itemResource.setCategory(item.getCategory());

        return itemResource;
    }

    @Override
    public ItemEntity fetchItemById(Long id) {
        return itemRepository.findById(id);
    }
}
