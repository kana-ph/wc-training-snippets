package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemPaginationResponse;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemPagination;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component 
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;
    private final ItemPagination itemPagination;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    ItemGatewayImpl(ItemRepository itemRepository, ItemPagination itemPagination, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.itemPagination = itemPagination;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Item create(ItemForm form) {
        ItemEntity entity = new ItemEntity();

        entity.setOwnerId(userRepository.findById(form.getId()));
        entity.setName(form.getName());
        entity.setCategoryId(categoryRepository.findById(form.getCategoryId()));
        entity.setStatus("Active");

        ItemEntity savedEntity = itemRepository.save(entity);

        Item item = new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        item.setOwnerId(savedEntity.getOwnerId());
        item.setCategoryId(savedEntity.getCategoryId());
        item.setStatus(savedEntity.getStatus());
        return item;
    }

    @Override
    public String deleteItem(Long id){
        ItemEntity deleteEntity = itemRepository.findById(id);
        deleteEntity.setStatus("Deleted");
        itemRepository.save(deleteEntity);
        return "Successfully Deleted";
    }

    @Override
    public ItemEntity getItem (Long id){
        ItemEntity item = itemRepository.findById(id);
        if(item.getStatus().equals("Active")){
            return item;
        }
        else{
            return null;
        }
    }

    @Override
    public ItemPaginationResponse<ItemEntity> showItems(Pageable pageable){
        pageable = PageRequest.of(0,2);
        Page<ItemEntity> result = itemPagination.findAll(pageable);
        return new ItemPaginationResponse<>(result.getContent(),result.getTotalPages(),result.getTotalElements());
    }


}
