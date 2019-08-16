package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    ItemGatewayImpl(ItemRepository itemRepository,
                    CategoryRepository categoryRepository,
                    UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Item create(ItemForm form) {

        ItemEntity entity = new ItemEntity();
        entity.setName(form.getName());
        entity.setCategory(categoryRepository.findById(form.getCategoryId()));
        entity.setOwner(userRepository.findById(form.getOwnerId()));

        ItemEntity savedEntity = itemRepository.save(entity);
        Item item = mapToModel(savedEntity);

        return item;
    }

    @Override
    public Page<Item> all(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ItemEntity> entities =  itemRepository.findAllByDeleted(false, pageable);
        Page<Item> items = entities.map((e) -> mapToModel(e));
        return items;
    }

    @Override
    public Page<Item> all(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ItemEntity> entities =  itemRepository.findAllByDeletedAndCategory_Name(false, category, pageable);
        Page<Item> items = entities.map((e) -> mapToModel(e));
        return items;
    }

    @Override
    public Item get(Long id) {
        ItemEntity entity = itemRepository.findByDeletedAndId(false, id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Item item = mapToModel(entity);
        return item;
    }

    @Override
    public void delete(Long id) {
        ItemEntity entity = itemRepository.findByDeletedAndId(false, id).map((e) -> {
            e.setDeleted(true);
            return itemRepository.save(e);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private Item mapToModel(ItemEntity entity) {
        Item item = new Item();
        item.setId(entity.getId());
        item.setDeleted(entity.getDeleted());
        item.setName(entity.getName());

        Category category = new Category();
        category.setId(entity.getCategory().getId());
        category.setName(entity.getCategory().getName());
        item.setCategory(category);

        User owner = new User();
        owner.setId(entity.getOwner().getId());
        owner.setName(entity.getOwner().getName());
        item.setOwner(owner);

        return item;
    }

}


