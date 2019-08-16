package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemPaginationRepo;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ItemPaginationRepo itemPaginationRepo;

    @Autowired
    public ItemGatewayImpl(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository, ItemPaginationRepo itemPaginationRepo) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.itemPaginationRepo = itemPaginationRepo;
    }

    @Override
    public Item create(ItemForm form) {
        ItemEntity entity = new ItemEntity();
        entity.setOwnerId(userRepository.getById(form.getOwnerId()));
        entity.setCategory(categoryRepository.getById(form.getCategoryId()));
        entity.setName(form.getName());
        entity.setStatus("Active");

        ItemEntity savedEntity = itemRepository.save(entity);

        CategoryEntity categoryEntity = categoryRepository.getById(form.getCategoryId());
        categoryEntity.setItems(savedEntity);

        Item item = new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        item.setOwnerId(savedEntity.getOwnerId());
        item.setCategoryId(savedEntity.getCategory());
        return item;
    }

    @Override
    public Item getItem(Long id) {
        ItemEntity foundId = itemRepository.findById(id);

        Item item = new Item();
        item.setId(foundId.getId());
        item.setName(foundId.getName());
        item.setOwnerId(foundId.getOwnerId());
        item.setCategoryId(foundId.getCategory());
        return item;
    }

    @Override
    public Item deleteItem(Long id) {
        ItemEntity itemToDelete = itemRepository.findById(id);
        itemToDelete.setStatus("Deleted");
        ItemEntity deletedItem = itemRepository.save(itemToDelete);

        Item item = new Item();
        itemToDelete.setStatus(deletedItem.getStatus());
        return null;
    }

    private Item mapEntityToModel(ItemEntity itemEntity){
        Item item = new Item();
        item.setId(itemEntity.getId());
        item.setName(itemEntity.getName());
        item.setOwnerId(itemEntity.getOwnerId());
        item.setCategoryId(itemEntity.getCategory());
        item.setStatus(itemEntity.getStatus());
        return item;
    }

    @Override
    public Page<Item> getItems(Pageable pageable) {
        Pageable page = PageRequest.of(0,5);

        return itemPaginationRepo.findAll(page).map(this::mapEntityToModel);
    }

    @Override
    public Page<Item> getItems(String category, Pageable pageable) {
        CategoryEntity entity = categoryRepository.getByName(category);
        return itemRepository.findAllByCategory(entity, pageable).map(this::mapEntityToModel);
    }
}
