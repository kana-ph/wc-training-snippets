package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.controller.response.PageResource;
import com.whitecloak.training.inventory.gateway.ItemGateway;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
class ItemServiceImpl implements ItemService {

    private final ItemGateway itemGateway;

    @Autowired
    ItemServiceImpl(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    @Override
    public ItemResource create(ItemForm form) {
        Item item = itemGateway.create(form);
        ItemResource itemResource = mapToResource(item);
        return itemResource;
    }

    @Override
    public PageResource<ItemResource> all(String category, int page, int size) {
        Page<Item> items = category.equals("") ? itemGateway.all(page, size) : itemGateway.all(category, page, size);
        PageResource<ItemResource> pageResource = new PageResource<>(
                items.map((i) -> mapToResource(i)).getContent(),
                items.getNumber(),
                items.getNumberOfElements(),
                items.getTotalPages()
        );
        return pageResource;
    }

    @Override
    public ItemResource get(Long id) {
        Item item = itemGateway.get(id);
        ItemResource resource = mapToResource(item);
        return resource;
    }

    @Override
    public void delete(Long id) {
        itemGateway.delete(id);
    }

    private ItemResource mapToResource(Item item) {
        ItemResource resource = new ItemResource();
        resource.setId(item.getId());
        resource.setName(item.getName());
        resource.setCategory(item.getCategory());
        resource.setOwner(item.getOwner());
        return resource;
    }

}
