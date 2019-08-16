package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.persistence.repository.PagingRepository;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
class ItemGatewayImpl implements ItemGateway {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ItemGatewayImpl(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }





    @Override
    public Item create(ItemForm form) {
        ItemEntity entity = new ItemEntity();
        entity.setName(form.getName());
        entity.setOwner(userRepository.getById(form.getOwnerId()));
        entity.setCategory(categoryRepository.getById(form.getCategoryId()));
        entity.setStatus("ACTIVE");

        ItemEntity savedEntity = itemRepository.save(entity);

        Item item = new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        item.setOwner(savedEntity.getOwner());
        item.setCategory(savedEntity.getCategory());
        return item;
    }
    @Override
    public Item getUser(Long id){
        ItemEntity result=itemRepository.findById(id);
        if(result.getStatus().equals("ACTIVE")){
            Item item = new Item();
            item.setId(result.getId());
            item.setName(result.getName());
            item.setOwner(result.getOwner());
            item.setCategory(result.getCategory());
            return item;
        }else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        ItemEntity result=itemRepository.findById(id);
        result.setStatus("INACTIVE");
        ItemEntity savedEntity=itemRepository.save(result);
        Item item=new Item();
        item.setId(savedEntity.getId());
        item.setName(savedEntity.getName());
        item.setOwner(savedEntity.getOwner());
        item.setCategory(savedEntity.getCategory());
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable).map(ItemEntity-> {
            Item item=new Item();
            item.setId(ItemEntity.getId());
            item.setName(ItemEntity.getName());
            item.setOwner(ItemEntity.getOwner());
            item.setCategory(ItemEntity.getCategory());
            return item;

        });
    }

    @Override
    public Page<Item> findAllByCategory_Name(String category, Pageable pageable) {
        return itemRepository.findAllByCategory_Name(category, pageable).map(ItemEntity->{

           Item item=new Item();
           //item.setStatus(ItemEntity.getStatus());
          // if(item.getStatus().equals("ACTIVE")){
               item.setId(ItemEntity.getId());
               item.setName(ItemEntity.getName());
               item.setOwner(ItemEntity.getOwner());
               item.setCategory(ItemEntity.getCategory());
               return item;
           //}


        });
    }
}
