package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.controller.response.PageResource;

public interface ItemService {

    ItemResource create(ItemForm form);
    PageResource<ItemResource> all(String category, int page, int size);
    ItemResource get(Long id);
    void delete(Long id);

}
