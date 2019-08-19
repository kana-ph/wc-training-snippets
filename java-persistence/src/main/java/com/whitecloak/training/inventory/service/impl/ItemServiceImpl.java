package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemPaginationResponse;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.repository.ItemPagination;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class  ItemServiceImpl implements ItemService {

    private final ItemGateway itemGateway;
    private final ItemPagination itemPagination;
    @Autowired
    ItemServiceImpl(ItemGateway itemGateway, ItemPagination itemPagination) {
        this.itemGateway = itemGateway;
        this.itemPagination = itemPagination;
    }

    @Override
    public ItemResource create(ItemForm form) {
        Item item = itemGateway.create(form);

        ItemResource itemResource = new ItemResource();
        itemResource.setId(item.getId());
        itemResource.setName(item.getName());
        itemResource.setOwnerId(item.getOwnerId());
        itemResource.setCategoryId(item.getCategoryId());
        itemResource.setStatus(item.getStatus());
        return itemResource;
    }

    @Override
    public ItemResource getItem(Long id){
        Item item = itemGateway.getItem(id);

        ItemResource resource = new ItemResource();
        resource.setId(item.getId());
        resource.setName(item.getName());
        resource.setOwnerId(item.getOwnerId());
        resource.setCategoryId(item.getCategoryId());
        resource.setStatus(item.getStatus());
        return resource;
    }


    @Override
    public ItemPaginationResponse<ItemEntity> findAllByPage(Pageable pageable){
        return itemGateway.showItems(pageable);
    }

    @Override
    public String deleteItem(Long id){
        return itemGateway.deleteItem(id);
    }


}
