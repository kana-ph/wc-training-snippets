package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

    ItemResource create(ItemForm form);

    ItemResource getItem(Long id);

    ItemResource deleteItem(Long id);

    Page<ItemResource> getItems(Pageable pageable);

    Page<ItemResource> getItems(String category, Pageable pageable);
}
